package com.example.taskapp

import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
/*private var allTasks= listOf<Task>(Task(1,"something","Hehe"),Task(2,"something 2","Haha"),Task(3,"something 3","lol"),
        Task(4,"read book ","atomic habits"),Task(5,"learn something","writing"),Task(6,"typing","type master"),Task(7,"exercise","gym")
    ,Task(8,"9","10"),Task(9,"sleep","sleep well"),Task(10,"something 10","desc 10"))*/
fun formatTask(task:List<Task>):Spanned{

    val sb = StringBuilder()
    sb.apply {
        append("<h3>Tasks : </h3>")
        append("<br>")
//        append("${task[index].id} -> ${task}")
        task.forEach{
            append("${it.id} -> ${it.task} -> ${it.desc}<br><br>")
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
        } else {
            return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
    }
}