package utils

fun readFileFromTestResources(fileName: String): String {
    return {}.javaClass.getResource("/$fileName")?.readText() ?: throw Exception("File $fileName not found")
}