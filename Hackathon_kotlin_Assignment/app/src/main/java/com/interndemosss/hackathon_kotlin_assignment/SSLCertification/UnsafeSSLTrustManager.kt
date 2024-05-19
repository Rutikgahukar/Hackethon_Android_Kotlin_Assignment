package com.interndemosss.hackathon_kotlin_assignment.SSLCertification

import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

class UnsafeSSLTrustManager : X509TrustManager {

    @Throws(CertificateException::class)
    override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
        // No implementation needed
    }

    @Throws(CertificateException::class)
    override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
        // No implementation needed
    }

    override fun getAcceptedIssuers(): Array<X509Certificate> {
        return arrayOf()
    }

    companion object {
        fun getUnsafeSSLContext(): SSLContext {
            return try {
                val sslContext = SSLContext.getInstance("SSL")
                sslContext.init(null, arrayOf<TrustManager>(UnsafeSSLTrustManager()), SecureRandom())
                sslContext
            } catch (e: NoSuchAlgorithmException) {
                throw RuntimeException("Failed to create SSL context", e)
            } catch (e: KeyManagementException) {
                throw RuntimeException("Failed to create SSL context", e)
            }
        }
    }
}
