package com.wcc.whatdoilearn.data

import com.wcc.whatdoilearn.entities.LearnedItem
import com.wcc.whatdoilearn.entities.UnderstandingLevel

class LearnedItemsDatabase {
    fun getAll(): List<LearnedItem> {
        val itemLearned1 = LearnedItem(
                "Kotlin - Null safety",
                "O sistema de tipos de Kotlin visa eliminar o perigo de referências nulas do código",
                UnderstandingLevel.HIGH
        )
        val itemLearned2 = LearnedItem(
                "Layout editor",
                "O Design Editor exibe o layout em vários dispositivos e versões do Android.É possível criar e editar um layout usando apenas componentes visuais.",
                UnderstandingLevel.MEDIUM
        )
        val itemLearned3 = LearnedItem(
                "Git",
                "É um sistema de controle de versão distribuído. Com ele é possível rastrear mudanças no código-fonte durante o desenvolvimento de software.",
                UnderstandingLevel.LOW
        )
        val itemLearned4 = LearnedItem(
                "GroupView",
                "É uma view especial que pode conter outras views (chamadas de filhos).É a classe base para layouts e contêineres de views.",
                UnderstandingLevel.HIGH
        )

        return listOf(itemLearned1, itemLearned2, itemLearned3, itemLearned4)
    }
}