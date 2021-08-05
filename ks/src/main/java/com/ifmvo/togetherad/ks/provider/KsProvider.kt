package com.ifmvo.togetherad.ks.provider

import android.app.Activity
import android.view.ViewGroup
import com.ifmvo.togetherad.core.listener.*
import com.ifmvo.togetherad.core.provider.BaseAdProvider

class KsProvider : BaseAdProvider() {

    override fun loadAndShowSplashAd(activity: Activity, adProviderType: String, alias: String, container: ViewGroup, listener: SplashListener) {

    }

    override fun loadOnlySplashAd(activity: Activity, adProviderType: String, alias: String, listener: SplashListener) {

    }

    override fun showSplashAd(container: ViewGroup): Boolean {
        return false
    }

    override fun showBannerAd(activity: Activity, adProviderType: String, alias: String, container: ViewGroup, listener: BannerListener) {

    }

    override fun destroyBannerAd() {

    }

    override fun requestInterAd(activity: Activity, adProviderType: String, alias: String, listener: InterListener) {

    }

    override fun showInterAd(activity: Activity) {

    }

    override fun destroyInterAd() {

    }

    override fun getNativeAdList(activity: Activity, adProviderType: String, alias: String, maxCount: Int, listener: NativeListener) {

    }

    override fun nativeAdIsBelongTheProvider(adObject: Any): Boolean {
        return false
    }

    override fun resumeNativeAd(adObject: Any) {

    }

    override fun pauseNativeAd(adObject: Any) {

    }

    override fun destroyNativeAd(adObject: Any) {

    }

    override fun getNativeExpressAdList(activity: Activity, adProviderType: String, alias: String, adCount: Int, listener: NativeExpressListener) {

    }

    override fun destroyNativeExpressAd(adObject: Any) {

    }

    override fun nativeExpressAdIsBelongTheProvider(adObject: Any): Boolean {
        return false
    }

    override fun requestRewardAd(activity: Activity, adProviderType: String, alias: String, listener: RewardListener) {

    }

    override fun showRewardAd(activity: Activity): Boolean {
        return false
    }

    override fun requestFullVideoAd(activity: Activity, adProviderType: String, alias: String, listener: FullVideoListener) {

    }

    override fun showFullVideoAd(activity: Activity): Boolean {
        return false
    }
}