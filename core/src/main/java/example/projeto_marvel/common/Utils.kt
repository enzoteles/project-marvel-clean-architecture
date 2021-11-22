package example.projeto_marvel.common

import java.text.DecimalFormat
import java.text.NumberFormat
import java.time.format.DateTimeFormatter
import java.util.*

fun Double.toPtBrRealStringWithoutSymbol(): String {
    val ptBrFormat = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
            as DecimalFormat
    ptBrFormat.minimumFractionDigits = 2
    val decimalFormatSymbols = ptBrFormat.decimalFormatSymbols
    decimalFormatSymbols.currencySymbol = ""

    ptBrFormat.decimalFormatSymbols = decimalFormatSymbols

    return ptBrFormat.format(this).trim()
}