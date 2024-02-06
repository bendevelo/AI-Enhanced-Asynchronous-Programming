package com.s.myapplication.ReaderEngine

class DictionaryReader(private val languageFileMap: Map<String, String> = LanguageClass.LANGUAGE_FILE_MAP) {


        fun readDictionaries(language: String, emoticons: Boolean): Map<String, String> {
            val filename = languageFileMap[language]
                ?: throw IllegalArgumentException("Unknown language: $language")

            val data = readWordFileFromResource(filename).toMutableMap()

            if (emoticons) {
                listOf("emoticons.txt", "emojis.txt").forEach { emoticon ->
                    data += readWordFileFromResource(emoticon)
                }
            }
            return data
        }


        fun cleanText(text: String): List<String> {
            return text.replace("[!',.?]".toRegex(), "").lowercase().split(" ")
        }

        private fun readWordFileFromResource(filename: String?): Map<String, String> {
            val wordDict = mutableMapOf<String, String>()
            if (filename != null) {
                val resource = DictionaryReader::class.java.classLoader?.getResourceAsStream("res/raw/"+filename)
                resource?.bufferedReader()?.readLines()?.forEach { line ->
                    val parts = line.trim().split("\t")
                    if (parts.size == 2) {
                        wordDict[parts[0]] = parts[1]
                    }
                }
            }
            println(wordDict.size)
            return wordDict
        }
    }
