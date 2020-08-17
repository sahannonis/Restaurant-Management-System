package com.example.imagerecycler;



import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.Date;

public class ViewHolder extends RecyclerView.ViewHolder {

    private FirebaseAuth firebaseAuth  = FirebaseAuth.getInstance();

    String user = firebaseAuth.getCurrentUser().getUid();
    int amount = 0;
    //firebase
    FirebaseDatabase dFirebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference dRefC = dFirebaseDatabase.getReference("Cart").child(user).push();
    DatabaseReference dRefD = dFirebaseDatabase.getReference("Cart").child(user).push();
    DatabaseReference dRefS = dFirebaseDatabase.getReference("Cart").child(user).push();
    DatabaseReference dRefT = dFirebaseDatabase.getReference("Order").child(user).push();

    String key = dRefC.child(user).push().getKey();

    DatabaseReference delete = dFirebaseDatabase.getReference("Cart").child(user);



    View qView;
    View dView;
    View pView;
    View deView;
    View ViView;
    View ViAmount;

    public ViewHolder(View itemView){
        super(itemView);

        qView = itemView;
        dView = itemView;
        pView = itemView;
        deView= itemView;
        ViView= itemView;
        ViAmount= itemView;
    }

    public void setDetails(Context cxt, final String name, final String imagename, final String description, final String small, final String medium, final String large){
        final TextView qName = qView.findViewById(R.id.pName);
        final TextView qDescription = qView.findViewById(R.id.pDescription);
        final TextView qSmall = qView.findViewById(R.id.pSmall);
        final TextView qMedium = qView.findViewById(R.id.pMedium);
        final TextView qLarge = qView.findViewById(R.id.pLarge);
        final ImageView qImagename = qView.findViewById(R.id.pImage);
        Button Addtocart = qView.findViewById(R.id.addtocart);

        Button Large = qView.findViewById(R.id.Pblarge);
        Button Medium = qView.findViewById(R.id.Pbmedium);
        Button Small = qView.findViewById(R.id.Pbsmall);


        Large.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Model1 model1 = new Model1(name, medium,imagename, large);//retieves name price of large as medium cause in Model class the placing of the constructors are incorrect there was no to configure it.

                dRefC.setValue(model1);


                Toast.makeText(v.getContext(), "Added to Cart", Toast.LENGTH_SHORT).show();


            }
        });
        Medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Model2 model2 = new Model2(name, small,imagename,large);

                dRefD.setValue(model2);

                Toast.makeText(v.getContext(), "Added to Cart", Toast.LENGTH_SHORT).show();

            }
        });
        Small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Model3 model3 = new Model3(name, description,imagename,large);

                dRefS.setValue(model3);

                Toast.makeText(v.getContext(), "Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });


        qName.setText(name);
        qMedium.setText("L  - "+medium); //large
        qLarge.setText(imagename);//description
        qDescription.setText("S  - " + description);//small
        qSmall.setText("M - "+small);//medium
 //The medium is showing description and the description is showing the medium and large is showing the image. Messed up android but it works.


        if (large.isEmpty()) {
         qView.setBackgroundColor(000);
        } else {
            Picasso.get().load(large).into(qImagename);

        }

    }
    public void setDetailsdrinks(Context cxt, final String name, final String imagename, final String description, final String small, final String medium, final String large){
        final TextView dName = dView.findViewById(R.id.dName);
        final TextView dDescription = dView.findViewById(R.id.dDescription);

        final TextView dMedium = dView.findViewById(R.id.dMedium);
        final TextView dLarge = dView.findViewById(R.id.dLarge);
        final ImageView dImagename = dView.findViewById(R.id.dImage);
        Button Addtocart = dView.findViewById(R.id.addtocart);
        Addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ModelDrink model4 = new ModelDrink(name, medium,imagename, large);

                dRefC.setValue(model4);
                Toast.makeText(v.getContext(), "Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });
        String url = "https://firebasestorage.googleapis.com/v0/b/logindemo-69d60.appspot.com/o/pizza%2Fbeef.jpg?alt=media&token=eef8b6e9-2705-48be-a863-2f31c7b39995";

        dName.setText(name);
        dMedium.setText("Price  - "+medium); //large
        dLarge.setText(imagename);//description


        //The medium is showing description and the description is showing the medium and large is showing the image. Messed up android but it works.

        Picasso.get().load(large).into(dImagename);


    }
    public void setDetailspasta(Context cxt, final String name, final String imagename, final String description, final String small, final String medium, final String large){
        final TextView dName = pView.findViewById(R.id.dName);
        final TextView dDescription = pView.findViewById(R.id.dDescription);

        final TextView dMedium = pView.findViewById(R.id.dMedium);
        final TextView dLarge = pView.findViewById(R.id.dLarge);
        final ImageView dImagename = pView.findViewById(R.id.dImage);
        Button Addtocart = pView.findViewById(R.id.addtocart);
        Addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ModelPasta modelpa = new ModelPasta(name, small,imagename, large);

                dRefC.setValue(modelpa);
                Toast.makeText(v.getContext(), "Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });
        String url = "https://firebasestorage.googleapis.com/v0/b/logindemo-69d60.appspot.com/o/pizza%2Fbeef.jpg?alt=media&token=eef8b6e9-2705-48be-a863-2f31c7b39995";

        dName.setText(name);

        dLarge.setText(imagename);//description
        dDescription.setText("Price: " + small);//small
        //The medium is showing description and the description is showing the medium and large is showing the image. Messed up android but it works.

        Picasso.get().load(large).into(dImagename);


    }
    public void setDetailsdesert(Context cxt, final String name, final String imagename, final String description, final String small, final String medium, final String large){
        final  TextView dName = deView.findViewById(R.id.dName);
        final TextView dDescription = deView.findViewById(R.id.dDescription);

        final TextView dMedium = deView.findViewById(R.id.dMedium);
        final TextView dLarge = deView.findViewById(R.id.dLarge);
        final ImageView dImagename = deView.findViewById(R.id.dImage);
        Button Addtocart = deView.findViewById(R.id.addtocart);
        Addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ModelDessert model11 = new ModelDessert(name, small,imagename, large);

                dRefC.setValue(model11);
                Toast.makeText(v.getContext(), "Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });
        String url = "https://firebasestorage.googleapis.com/v0/b/logindemo-69d60.appspot.com/o/pizza%2Fbeef.jpg?alt=media&token=eef8b6e9-2705-48be-a863-2f31c7b39995";


        dName.setText(name);

        dLarge.setText(imagename);//description
        dDescription.setText("Price: " + small);//small

        //The medium is showing description and the description is showing the medium and large is showing the image. Messed up android but it works.

        Picasso.get().load(large).into(dImagename);


    }
    public void setViewCart(Context cxt, final String name, final String imagename, final String description, final String price){
        final  TextView dName = ViView.findViewById(R.id.vName);
        final TextView dDescription = ViView.findViewById(R.id.vDescription);


        final TextView dLarge = ViView.findViewById(R.id.vLarge);
        final ImageView dImagename = ViView.findViewById(R.id.vImage);

        Button removecart = ViView.findViewById(R.id.btnremove);

        removecart.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v)
                                          {
                                             // String key = dRefC.getKey();
                                             // Task<Void> delete = dFirebaseDatabase.getReference("Cart").child(user).child(key).removeValue();

                                              delete.removeValue();
                                              Toast.makeText(v.getContext(), "Removed From Cart", Toast.LENGTH_SHORT).show();
                                          }
                                      });



                String url = "https://firebasestorage.googleapis.com/v0/b/logindemo-69d60.appspot.com/o/pizza%2Fbeef.jpg?alt=media&token=eef8b6e9-2705-48be-a863-2f31c7b39995";

        dName.setText(name);

        dLarge.setText(imagename);//description
        dDescription.setText("Price: " + description);//small

        //The medium is showing description and the description is showing the medium and large is showing the image. Messed up android but it works.

        Picasso.get().load(price).into(dImagename);



//        amount = amount + Integer.parseInt(description);

 //       Intent intent =  new Intent(cxt,PaymentAction.class);

  //      intent.putExtra("total",amount);
        //cxt.startActivity(intent);
       // final TextView TotalPrice = ViAmount.findViewById(R.id.TotalPrice);
      //  TotalPrice.setText("Total: " + String.valueOf(amount));
    }



   /*public void setOrder(Context cxt,final String type){
        //Date datetime = Calendar.getInstance().getTime();
        Button Addtocart = deView.findViewById(R.id.placeorder);
        Addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModelOrder modelorder = new ModelOrder(type);

                dRefT.setValue(modelorder);
                Toast.makeText(v.getContext(), "Order Made", Toast.LENGTH_SHORT).show();
            }
        });


    }
*/
}
