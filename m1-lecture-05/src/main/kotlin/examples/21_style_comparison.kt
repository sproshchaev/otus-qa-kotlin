package examples

fun html(block: StringBuilder.() -> Unit): String {
    val sb = StringBuilder()
    sb.block()
    return sb.toString()
}

fun main() {
    // С лямбдой внутри скобок (менее читаемо)
    val html1 = html({
        append("<html>")
        append("<body>")
        append("<h1>Заголовок</h1>")
        append("</body>")
        append("</html>")
    })

    // С лямбдой за скобками (более читаемо)
    val html2 = html {
        append("<html>")
        append("<body>")
        append("<h1>Заголовок</h1>")
        append("</body>")
        append("</html>")
    }

    println(html1)
    println(html2)
}