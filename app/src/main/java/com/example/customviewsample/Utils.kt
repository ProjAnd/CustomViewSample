import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import com.example.customviewsample.R

object Utils {
    fun showDialogBox(context: Context){
        var dialog = Dialog(context, R.style.customDialog)
        dialog.apply {
            setContentView(LayoutInflater.from(context).inflate(R.layout.custom_dialog, null, false))
            findViewById<Button>(R.id.btn_ok).setOnClickListener {
                Toast.makeText(context, "Ok Clicked", Toast.LENGTH_SHORT).show()
            }
            findViewById<Button>(R.id.btn_cancel).setOnClickListener {
                dialog.dismiss()
            }
        }
        dialog.show()
    }

    fun showAlertDialogBix(context: Context){
                var dialog = AlertDialog.Builder(context, R.style.customDialog).apply {
               // title = "Alert !"
                setMessage("This is alertDialog box")
                    setView(R.layout.custom_dialog)
                        .setPositiveButton("ok", DialogInterface.OnClickListener { dialogInterface, i ->

                        })
                        .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
                            //dialog.dismiss()
                        })

            }.create().show()
    }

    fun showToastSuccess(context: Context){
        var successToast = Toast(context)
        successToast.apply {

            duration = Toast.LENGTH_LONG
            setGravity(Gravity.FILL_HORIZONTAL,0,0)
            view = LayoutInflater.from(context).inflate(R.layout.toast_success, null)
        }.show()
    }
    fun showToastFailure(context: Context){
        var successToast = Toast(context)
        successToast.apply {

            duration = Toast.LENGTH_LONG
            setGravity(Gravity.FILL_HORIZONTAL,0,0)
            view = LayoutInflater.from(context).inflate(R.layout.toast_failure, null)
        }.show()
    }



}