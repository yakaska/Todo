package ru.yakaska.todo.data
//
//import android.content.Context
//import android.util.Log
//import androidx.room.RoomDatabase
//import androidx.sqlite.db.SupportSQLiteDatabase
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import org.json.JSONArray
//import org.json.JSONException
//import ru.yakaska.todo.R
//import ru.yakaska.todo.model.Task
//import java.io.BufferedReader
//import java.time.LocalDateTime
//
//class PrepopulateTodo(private val context: Context) : RoomDatabase.Callback() {
//
//    override fun onCreate(db: SupportSQLiteDatabase) {
//        super.onCreate(db)
//        CoroutineScope(Dispatchers.IO).launch {
//            insertTodos(context)
//        }
//    }
//
//    private fun loadJSONArray(context: Context): JSONArray {
//
//        val inputStream = context.resources.openRawResource(R.raw.todo)
//
//        BufferedReader(inputStream.reader()).use {
//            return JSONArray(it.readText())
//        }
//    }
//
//    private fun insertTodos(context: Context) {
//
//        val dao = TodoDatabase.getDatabase(context).todoDao()
//
//        try {
//            val todos = loadJSONArray(context)
//            if (todos.length() > 0) {
//                Log.d("Pre-population", "fillWithStartingNotes")
//
//                for (i in 0 until todos.length()) {
//                    val item = todos.getJSONObject(i)
//                    val title = item.getString("title")
//                    val description = item.getString("description")
//                    val isDone = item.getBoolean("isDone")
//                    val createdAt = LocalDateTime.now()
//                    val expireAt = LocalDateTime.now().plusDays(i.toLong())
//
//                    val taskEntity = Task(
//                        title = title,
//                        description = description,
//                        isDone = isDone,
//                        createdAt = createdAt,
//                        expireAt = expireAt
//                    )
//
//                    dao.insertTodo(taskEntity)
//                }
//            }
//        } catch (e: JSONException) {
//            Log.d("Pre-population", "fillWithStartingNotes: $e")
//        }
//    }
//
//}