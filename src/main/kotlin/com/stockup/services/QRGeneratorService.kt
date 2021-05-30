package com.stockup.services

import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.google.zxing.common.CharacterSetECI
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel
import com.soywiz.korim.bitmap.Bitmap
import io.quarkus.runtime.Startup
import java.util.*
import javax.enterprise.context.ApplicationScoped

@Startup
@ApplicationScoped
class QRGeneratorService {

   /* @Throws(WriterException::class)
    private fun generateQR(value: String): Bitmap? {
        val bitMatrix: BitMatrix
        try {
            val hints = EnumMap<EncodeHintType, Any>(EncodeHintType::class.java)
            hints[EncodeHintType.ERROR_CORRECTION] = ErrorCorrectionLevel.H
            hints[EncodeHintType.CHARACTER_SET] = CharacterSetECI.UTF8
            bitMatrix = MultiFormatWriter().encode(value, BarcodeFormat.QR_CODE, 500, 500, hints)
        } catch (exception: IllegalArgumentException) {
            return null
        }
        val bitMatrixWidth = bitMatrix.width
        val bitMatrixHeight = bitMatrix.height
        val pixels = IntArray(bitMatrixWidth * bitMatrixHeight)
        for (y in 0 until bitMatrixHeight) {
            val offset = y * bitMatrixWidth
            for (x in 0 until bitMatrixWidth) {
                pixels[offset + x] = if (bitMatrix.get(x, y)) 1 else 0
            }
        }
        val bitmap = Bitmap.createWithThisFormatTyped(bitMatrixWidth, bitMatrixHeight, Bitmap.toBMP32IfRequired())
        bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight)
        return bitmap
    }*/


}