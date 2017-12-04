package application.android.com.testsmsmananger

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.telephony.SmsManager
import android.view.View


class MainActivity : AppCompatActivity() {

    var phoneNumber = "5556"
    var smsBody = "This is an SMS!"

    var SMS_SENT = "SMS_SENT"
    //var SMS_DEL = android.provider.Telephony.Sms.
    var SMS_DELIVERED = "android.provider.Telephony.SMS_RECEIVED"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById(R.id.button)

        button.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v:View) {
                sendSMS(phoneNumber, v.getContext(), smsBody)
            }
        })
    }

    private fun sendSMS(phoneNumber: String, context: Context, smsMessage: String)  {
            var sentPendingIntent = PendingIntent.getBroadcast(context, 0, Intent(SMS_SENT), 0)
            var deliveredPendingIntent = PendingIntent.getBroadcast(context, 0, Intent(SMS_DELIVERED), 0)

            // Get the default instance of SmsManager
            val smsManager = SmsManager.getDefault()
            // Send a text based SMS
            smsManager.sendTextMessage(phoneNumber, null, smsBody, sentPendingIntent, deliveredPendingIntent)


            /*SmsManager smsMgr = SmsManager.getDefault();
            ArrayList<string> smsMessageText = smsMgr.divideMessage(smsMessage.getMsgBody());
            PendingIntent sentPI = PendingIntent.getBroadcast(context, 0, new Intent("SMS_SENT"), 0);
            PendingIntent deliveredPI = PendingIntent.getBroadcast(context, 0, new Intent("SMS_DELIVERED"), 0);
            int AddresseesPerMessage = 10;
            StringBuilder builder = new StringBuilder();
            String delim = "";
            for (ContactItem c:smsMessage.getAddresseeList()) {
            //  For every phone number in our list
            builder.append(delim).append(c.getPhoneNumber().toString());
            delim=";";
            if (((smsMessage.getAddresseeList().indexOf(c)+1) % AddresseesPerMessage) == 0 || smsMessage.getAddresseeList().indexOf(c)+1 == smsMessage.getAddresseeList().size()) {
                // using +1 because index 0 mod 9 == 0
                for(String text : smsMessageText){
                    //  Send 160 bytes of the total message until all parts are sent
                    smsMgr.sendTextMessage(builder.toString(), null, text, sentPI, deliveredPI);
                }
                builder.setLength(0);
                delim="";
            }
        } */




        /*val sms = SmsManager.getDefault()
          sms.sendTextMessage("5554", null, "testMessage", null, null)
        val pendingList = ArrayList<Message>()
        for (message in list) {
            if (!message.isSentOut) {
                message.status = Message.PENDING
                pendingList.add(message)
            }
        }
        Toast.makeText(this, "Sending " + list.size + " messages.", Toast.LENGTH_SHORT).show()
        val sms = SmsManager.getDefault()
        object : Thread() {
            override fun run() {
                super.run()

                String[] exp = exressions[i].split(' ');
                for (message in pendingList) {
                    handler.post { Toast.makeText(this@MainActivity, "Sending: " + message.destination + "(" + list.indexOf(message) + ")", Toast.LENGTH_SHORT).show() }
                    val sentIntent = Intent("SENT_SMS_ACTION")
                    sentIntent.putExtra("sent_message", message)
                    val sentPendingIntent = PendingIntent.getBroadcast(this@MainActivity, list.indexOf(message), sentIntent, PendingIntent.FLAG_CANCEL_CURRENT)
                    val contents = sms.divideMessage(message.content)
                    val PendingIntents = ArrayList<PendingIntent>()
                    for (i in contents.indices)
                        PendingIntents.add(sentPendingIntent)
                    sms.sendMultipartTextMessage(message.destination, null, contents, PendingIntents, null)
                    message.status = Message.SENDING
                    handler.post { refreshListView() }
                    try {
                        Thread.sleep(4000)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }

                }
            }
        }.start()

    }*/
    }
}
