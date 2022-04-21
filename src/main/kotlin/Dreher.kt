import org.apache.pdfbox.Loader
import org.apache.pdfbox.pdmodel.PDDocument

import java.io.File


class Dreher {

    fun dreh(args: Array<String>) {

        val file:File = File(args[0])
       if (file.extension.equals(other = "pdf", ignoreCase = true)
           || file.extension.equals(other = "pdfa", ignoreCase = true)) {
           file.let {
               pdfDrehen(it)
           }
       }
    }
}

fun pdfDrehen(file: File) {
    val doc = Loader.loadPDF(file)
    var newDoc = PDDocument()
    doc.documentCatalog.pages.reversed(). forEach{
        it.rotation=180
        newDoc.addPage(it)
    }
    newDoc.save("${file.nameWithoutExtension}_gedreht.pdf")
    newDoc.close()
    doc.close()
}