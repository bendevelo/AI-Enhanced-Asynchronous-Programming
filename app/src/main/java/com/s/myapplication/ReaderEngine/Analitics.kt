package com.s.myapplication.ReaderEngine


class Analitics(private val language: String = "en", private val emoticons: Boolean = false) {
    private var wordDict: Map<String, String>
    private val dictionaryReader = DictionaryReader()


    init {
        wordDict = dictionaryReader.readDictionaries(language, emoticons)
    }

    fun score(text: String): Double {
        val cleanedText = dictionaryReader.cleanText(text)
        return cleanedText.sumOf { word: String ->
            wordDict.getOrDefault(word, "0").toDouble()
        }
    }


    fun scoreToWords(text: String): String {
        val scored = score(text)
        return when {
            scored in -1.0..1.0 -> "neutral"
            scored > 1.0 -> "positive"
            else -> "negative"
        }
    }
}