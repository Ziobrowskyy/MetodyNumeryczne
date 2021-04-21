abstract class Task {
   abstract val name: String
   protected abstract fun runTask(): Unit
   protected fun printThinSeparator() {
      println("--------------------")
   }
   protected fun printThickSeparator() {
      println("####################")
   }
   fun run() {
      printThickSeparator()
      println(name)
      printThinSeparator()
      runTask()
      printThickSeparator()
   }
}