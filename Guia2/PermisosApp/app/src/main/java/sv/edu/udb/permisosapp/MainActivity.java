package sv.edu.udb.permisosapp;

import static android.Manifest.permission.READ_CONTACTS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView lblPermission;
    private TextView lblContact;
    private final int MY_PERMISSIONS = 100;

    private final int OPEN_CONTACT = 200;

    private final String str_accepted = "ACCEPTED";
    private final String str_declined = "DECLINED";
    private String state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        state = "Estado del permiso:";

        lblPermission = findViewById(R.id.lblPermission);
        lblContact = findViewById(R.id.lblContact);

        if (verifyPermission())
            lblPermission.setText(state + " " + str_accepted);
        else
            lblPermission.setText(state + " " + str_declined);
    }

    public boolean verifyPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) return true;

        if (checkSelfPermission(READ_CONTACTS) == PackageManager.PERMISSION_GRANTED)
            return true;

        return false;
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void clickContact(View view) {
        if (verifyPermission()) {
            lblPermission.setText(state + " " + str_accepted);
            Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
            startActivityForResult(intent, OPEN_CONTACT);
        } else {
            requestPermissions(new String[]{READ_CONTACTS}, MY_PERMISSIONS);
        }
    }

    @SuppressLint("Range")
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case OPEN_CONTACT:
                    Uri contactUri = data.getData();

                    Cursor cursor = getContentResolver().query(contactUri, null, null, null, null);

                    String name = "\n" + "Contacto Seleccionado: " + "\n";

                    if (cursor.moveToFirst()) {
                        name = name + cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    }
                    lblContact.setText(name);
                    break;
            }
        }
    }

    @Override
    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grandResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grandResults);

        if (requestCode >= MY_PERMISSIONS) {
            if (grandResults.length > 0 && grandResults[0] == PackageManager.PERMISSION_GRANTED) {
                lblPermission.setText(state + " " + str_accepted);

                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);

                startActivityForResult(intent, OPEN_CONTACT);
            } else {
                lblPermission.setText(state + " " + str_declined);
            }
        }
    }
}