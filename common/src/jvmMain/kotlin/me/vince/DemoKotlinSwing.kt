package me.vince

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.awt.BorderLayout
import javax.swing.*

@OptIn(DelicateCoroutinesApi::class)
class DemoKotlinSwing : JFrame() {
    private val chuckNorrisFactService = ChuckNorrisFactService("http://localhost:8888/api")

    init {
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE

        layout = BorderLayout()

        val greeting = Greeting().greeting()
        add(JLabel(greeting), BorderLayout.NORTH)

        val listModel = DefaultListModel<String>()
        val jList = JList(listModel)
        add(jList, BorderLayout.CENTER)

        val button = JButton("Chuck Norris Fact")
        add(button, BorderLayout.SOUTH)
        button.addActionListener {
            GlobalScope.launch {
                val fact = chuckNorrisFactService.fetchFact()
                listModel.addElement(fact.value)
            }
        }

        pack()
        isVisible = true
    }

}

fun main() {
    SwingUtilities.invokeLater(::DemoKotlinSwing)
}
