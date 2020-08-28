# Interstitial 插屏广告

```kotlin
class InterActivity : AppCompatActivity() {

    private var adHelperInter: AdHelperInter? = null

    companion object {
        fun action(context: Context) {
            context.startActivity(Intent(context, InterActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inter)

        //使用 Map<String, Int> 配置广告商 权重，通俗的讲就是 随机请求的概率占比
        val radioMapInter = mapOf(
                AdProviderType.GDT.type to 1,
                AdProviderType.CSJ.type to 1,
                AdProviderType.BAIDU.type to 1
        )
        adHelperInter = AdHelperInter(activity = this, alias = TogetherAdAlias.AD_INTER, /*radioMap = radioMapInter,*/ listener = object : InterListener {
            override fun onAdStartRequest(providerType: String) {
                //在开始请求之前会回调此方法，失败切换的情况会回调多次
                addLog("开始请求了，$providerType")
            }

            override fun onAdLoaded(providerType: String) {
                //广告请求成功的回调，每次请求只回调一次
                addLog("请求到了，$providerType")
            }

            override fun onAdFailed(providerType: String, failedMsg: String?) {
                //请求失败的回调，失败切换的情况会回调多次
                addLog("单个广告请求失败, $providerType, $failedMsg")
            }

            override fun onAdFailedAll() {
                //所有配置的广告商都请求失败了，只有在全部失败之后会回调一次
                addLog("全部请求失败了")
            }

            override fun onAdClicked(providerType: String) {
                //点击广告的回调
                addLog("点击了，$providerType")
            }

            override fun onAdExpose(providerType: String) {
                //广告展示曝光的回调；由于 Banner 广告存在自动刷新功能，所以曝光会回调多次，每次刷新都会回调
                addLog("曝光了，$providerType")
            }

            override fun onAdClose(providerType: String) {
                //广告被关闭的回调
                addLog("关闭了，$providerType")
            }
        })

        btnRequest.setOnClickListener {
            //开始请求插屏广告
            adHelperInter?.load()
        }

        btnShow.setOnClickListener {
            //开始展示插屏广告，必须在 onAdLoaded 回调之后展示
            adHelperInter?.show()
        }

    }

    private var logStr = "日志: \n"

    private fun addLog(content: String?) {
        logStr = logStr + content + "\n"
        log.text = logStr

        info.post { info.fullScroll(View.FOCUS_DOWN) }
    }
}
```

可查看 Demo 中 [Interstitial插屏广告的示例代码](../demo/src/main/java/com/ifmvo/togetherad/demo/inter/InterActivity.kt)