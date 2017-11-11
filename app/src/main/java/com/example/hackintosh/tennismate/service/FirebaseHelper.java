package com.example.hackintosh.tennismate.service;

import com.example.hackintosh.tennismate.portability.Consumer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by nicu on 11/11/17.
 */

public class FirebaseHelper {
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();

    private FirebaseHelper() {
    }

    public static void setValue(String ref, Object value, Runnable onSuccess, Consumer<String> onError) {
        DatabaseReference reference = getReference(ref);



        reference.setValue(value, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if(databaseError != null){
                    onError.accept(databaseError.getMessage());
                } else {
                    onSuccess.run();
                }
            }
        });
    }

    public static <T> void getValue(String ref, Class<T> klass, Consumer<T> consumer, Consumer<String> error) {

        DatabaseReference reference = database.getReference(ref);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                T value = dataSnapshot.getValue(klass);

                consumer.accept(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                error.accept(databaseError.getMessage());
            }
        });
    }

    private static DatabaseReference getReference(String reference){
        DatabaseReference result = database.getReference();

        String[] split = reference.split("/");

        for (String node : split){
            result = result.child(node);
        }

        return result;
    }
}
