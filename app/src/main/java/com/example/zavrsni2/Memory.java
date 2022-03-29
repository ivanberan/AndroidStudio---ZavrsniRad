package com.example.zavrsni2;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Memory extends AppCompatActivity {

        TextView tvp1, tvp2,tvCounter;
        ImageView im_11, im_12, im_13, im_14, im_21, im_22, im_23, im_24, im_31, im_32, im_33, im_34, im_41, im_42, im_43, im_44, im_51, im_52, im_53, im_54;

        Integer[] cardsArray = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 201, 202, 203, 204, 205, 206, 207,208,209,210};
        int image101, image102, image103, image104, image105, image106, image107, image108, image109, image110, image201, image202, image203, image204, image205, image206, image207, image208, image209, image210;
        Integer[] imagearray1={image101, image102, image103, image104, image105, image106, image107, image108, image109, image110};
        Integer[] imagearray2={image201, image202, image203, image204, image205, image206, image207, image208, image209, image210};
        int firstcard, secondcard;
        int clickedfirst, clickedsecond;
        int cardnumber = 1;
        int turn = 1;
        int playerPoint = 0, cpuPoint = 0;
        int Counter=0;
       int sessionId;
        private String filename;
        //
        @Override
        protected void onCreate(Bundle savedInstanceState) {
          sessionId= getIntent().getIntExtra("players",1);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_memory);

            tvp1 = (TextView) findViewById(R.id.tvp1);
            tvp2 = (TextView) findViewById(R.id.tvp2);
            tvCounter=(TextView)findViewById(R.id.tvCounter);

           if(sessionId==1){
                tvp1.setVisibility(View.INVISIBLE);
                tvp2.setVisibility(View.INVISIBLE);

            }else{
                tvCounter.setVisibility(View.INVISIBLE);

            }

            im_11 = (ImageView) findViewById(R.id.iv_11);
            im_12 = (ImageView) findViewById(R.id.iv_12);
            im_13 = (ImageView) findViewById(R.id.iv_13);
            im_14 = (ImageView) findViewById(R.id.iv_14);
            im_21 = (ImageView) findViewById(R.id.iv_21);
            im_22 = (ImageView) findViewById(R.id.iv_22);
            im_23 = (ImageView) findViewById(R.id.iv_23);
            im_24 = (ImageView) findViewById(R.id.iv_24);
            im_31 = (ImageView) findViewById(R.id.iv_31);
            im_32 = (ImageView) findViewById(R.id.iv_32);
            im_33 = (ImageView) findViewById(R.id.iv_33);
            im_34 = (ImageView) findViewById(R.id.iv_34);
            im_41 = (ImageView) findViewById(R.id.iv_41);
            im_42 = (ImageView) findViewById(R.id.iv_42);
            im_43 = (ImageView) findViewById(R.id.iv_43);
            im_44 = (ImageView) findViewById(R.id.iv_44);
            im_51 = (ImageView) findViewById(R.id.iv_51);
            im_52 = (ImageView) findViewById(R.id.iv_52);
            im_53 = (ImageView) findViewById(R.id.iv_53);
            im_54 = (ImageView) findViewById(R.id.iv_54);

            im_11.setTag("0");
            im_12.setTag("1");
            im_13.setTag("2");
            im_14.setTag("3");
            im_21.setTag("4");
            im_22.setTag("5");
            im_23.setTag("6");
            im_24.setTag("7");
            im_31.setTag("8");
            im_32.setTag("9");
            im_33.setTag("10");
            im_34.setTag("11");
            im_41.setTag("12");
            im_42.setTag("13");
            im_43.setTag("14");
            im_44.setTag("15");
            im_51.setTag("16");
            im_52.setTag("17");
            im_53.setTag("18");
            im_54.setTag("19");

            frontofthecardsResources();
            Collections.shuffle(Arrays.asList(cardsArray));

            tvp2.setTextColor(Color.GRAY);

            im_11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int theCard = Integer.parseInt((String) view.getTag());
                    doStuff(im_11, theCard);
                }
            });
            im_12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int theCard = Integer.parseInt((String) view.getTag());
                    doStuff(im_12, theCard);
                }
            });
            im_13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int theCard = Integer.parseInt((String) view.getTag());
                    doStuff(im_13, theCard);
                }
            });
            im_14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int theCard = Integer.parseInt((String) view.getTag());
                    doStuff(im_14, theCard);
                }
            });
            im_21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int theCard = Integer.parseInt((String) view.getTag());
                    doStuff(im_21, theCard);
                }
            });
            im_22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int theCard = Integer.parseInt((String) view.getTag());
                    doStuff(im_22, theCard);
                }
            });
            im_23.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int theCard = Integer.parseInt((String) view.getTag());
                    doStuff(im_23, theCard);
                }
            });
            im_24.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int theCard = Integer.parseInt((String) view.getTag());
                    doStuff(im_24, theCard);
                }
            });
            im_31.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int theCard = Integer.parseInt((String) view.getTag());
                    doStuff(im_31, theCard);
                }
            });
            im_32.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int theCard = Integer.parseInt((String) view.getTag());
                    doStuff(im_32, theCard);
                }
            });
            im_33.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int theCard = Integer.parseInt((String) view.getTag());
                    doStuff(im_33, theCard);
                }
            });
            im_34.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int theCard = Integer.parseInt((String) view.getTag());
                    doStuff(im_34, theCard);
                }
            });
            im_41.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int theCard = Integer.parseInt((String) view.getTag());
                    doStuff(im_41, theCard);
                }
            });
            im_42.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int theCard = Integer.parseInt((String) view.getTag());
                    doStuff(im_42, theCard);
                }
            });
            im_43.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int theCard = Integer.parseInt((String) view.getTag());
                    doStuff(im_43, theCard);
                }
            });
            im_44.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int theCard = Integer.parseInt((String) view.getTag());
                    doStuff(im_44, theCard);
                }
            });
            im_51.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int theCard = Integer.parseInt((String) view.getTag());
                    doStuff(im_51, theCard);
                }
            });
            im_52.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int theCard = Integer.parseInt((String) view.getTag());
                    doStuff(im_52, theCard);
                }
            });
            im_53.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int theCard = Integer.parseInt((String) view.getTag());
                    doStuff(im_53, theCard);
                }
            });
            im_54.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int theCard = Integer.parseInt((String) view.getTag());
                    doStuff(im_54, theCard);
                }
            });









        }
/////////////////////////////
        private void doStuff(ImageView iv, int card) {
            Counter++;
            tvCounter.setText("Counter : " + Counter);
            if (cardsArray[card] == 101) {
                iv.setImageResource(imagearray1[0]);
            } else if (cardsArray[card] == 102) {
                iv.setImageResource(imagearray1[1]);
            } else if (cardsArray[card] == 103) {
                iv.setImageResource(imagearray1[2]);
            } else if (cardsArray[card] == 104) {
                iv.setImageResource(imagearray1[3]);
            } else if (cardsArray[card] == 105) {
                iv.setImageResource(imagearray1[4]);
            } else if (cardsArray[card] == 106) {
                iv.setImageResource(imagearray1[5]);
            } else if (cardsArray[card] == 107) {
                iv.setImageResource(imagearray1[6]);
            } else if (cardsArray[card] == 108) {
                iv.setImageResource(imagearray1[7]);
            } else if (cardsArray[card] == 109) {
                iv.setImageResource(imagearray1[8]);
            } else if (cardsArray[card] == 110) {
                iv.setImageResource(imagearray1[9]);
            } else if (cardsArray[card] == 201) {
                iv.setImageResource(imagearray2[0]);
            } else if (cardsArray[card] == 202) {
                iv.setImageResource(imagearray2[1]);
            } else if (cardsArray[card] == 203) {
                iv.setImageResource(imagearray2[2]);
            } else if (cardsArray[card] == 204) {
                iv.setImageResource(imagearray2[3]);
            } else if (cardsArray[card] == 205) {
                iv.setImageResource(imagearray2[4]);
            } else if (cardsArray[card] == 206) {
                iv.setImageResource(imagearray2[5]);
            } else if (cardsArray[card] == 207) {
                iv.setImageResource(imagearray2[6]);
            } else if (cardsArray[card] == 208) {
                iv.setImageResource(imagearray2[7]);
            } else if (cardsArray[card] == 209) {
                iv.setImageResource(imagearray2[8]);
            } else if (cardsArray[card] == 210) {
                iv.setImageResource(imagearray2[9]);
            }


            if (cardnumber == 1) {
                firstcard = cardsArray[card];
                if (firstcard > 200) {
                    firstcard -= 100;
                }
                cardnumber = 2;
                clickedfirst = card;
                iv.setEnabled(false);
            } else if (cardnumber == 2) {
                secondcard = cardsArray[card];
                if (secondcard > 200) {
                    secondcard -= 100;
                }
                cardnumber = 1;
                clickedsecond = card;

                im_11.setEnabled(false);
                im_12.setEnabled(false);
                im_13.setEnabled(false);
                im_14.setEnabled(false);
                im_21.setEnabled(false);
                im_22.setEnabled(false);
                im_23.setEnabled(false);
                im_24.setEnabled(false);
                im_31.setEnabled(false);
                im_32.setEnabled(false);
                im_33.setEnabled(false);
                im_34.setEnabled(false);
                im_41.setEnabled(false);
                im_42.setEnabled(false);
                im_43.setEnabled(false);
                im_44.setEnabled(false);
                im_51.setEnabled(false);
                im_52.setEnabled(false);
                im_53.setEnabled(false);
                im_54.setEnabled(false);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        calculate();
                    }
                }, 1000);

            }
        }

        private void calculate() {
            if (firstcard == secondcard) {
                if (clickedfirst == 0) {
                    im_11.setVisibility(View.INVISIBLE);
                } else if (clickedfirst == 1) {
                    im_12.setVisibility(View.INVISIBLE);
                } else if (clickedfirst == 2) {
                    im_13.setVisibility(View.INVISIBLE);
                } else if (clickedfirst == 3) {
                    im_14.setVisibility(View.INVISIBLE);
                } else if (clickedfirst == 4) {
                    im_21.setVisibility(View.INVISIBLE);
                } else if (clickedfirst == 5) {
                    im_22.setVisibility(View.INVISIBLE);
                } else if (clickedfirst == 6) {
                    im_23.setVisibility(View.INVISIBLE);
                } else if (clickedfirst == 7) {
                    im_24.setVisibility(View.INVISIBLE);
                } else if (clickedfirst == 8) {
                    im_31.setVisibility(View.INVISIBLE);
                } else if (clickedfirst == 9) {
                    im_32.setVisibility(View.INVISIBLE);
                } else if (clickedfirst == 10) {
                    im_33.setVisibility(View.INVISIBLE);
                } else if (clickedfirst == 11) {
                    im_34.setVisibility(View.INVISIBLE);
                }else if (clickedfirst == 12) {
                    im_41.setVisibility(View.INVISIBLE);
                } else if (clickedfirst == 13) {
                    im_42.setVisibility(View.INVISIBLE);
                } else if (clickedfirst == 14) {
                    im_43.setVisibility(View.INVISIBLE);
                } else if (clickedfirst == 15) {
                    im_44.setVisibility(View.INVISIBLE);
                } else if (clickedfirst == 16) {
                    im_51.setVisibility(View.INVISIBLE);
                } else if (clickedfirst == 17) {
                    im_52.setVisibility(View.INVISIBLE);
                } else if (clickedfirst == 18) {
                    im_53.setVisibility(View.INVISIBLE);
                } else if (clickedfirst == 19) {
                    im_54.setVisibility(View.INVISIBLE);
                }

                if (clickedsecond == 0) {
                    im_11.setVisibility(View.INVISIBLE);
                } else if (clickedsecond == 1) {
                    im_12.setVisibility(View.INVISIBLE);
                } else if (clickedsecond == 2) {
                    im_13.setVisibility(View.INVISIBLE);
                } else if (clickedsecond == 3) {
                    im_14.setVisibility(View.INVISIBLE);
                } else if (clickedsecond == 4) {
                    im_21.setVisibility(View.INVISIBLE);
                } else if (clickedsecond == 5) {
                    im_22.setVisibility(View.INVISIBLE);
                } else if (clickedsecond == 6) {
                    im_23.setVisibility(View.INVISIBLE);
                } else if (clickedsecond == 7) {
                    im_24.setVisibility(View.INVISIBLE);
                } else if (clickedsecond == 8) {
                    im_31.setVisibility(View.INVISIBLE);
                } else if (clickedsecond == 9) {
                    im_32.setVisibility(View.INVISIBLE);
                } else if (clickedsecond == 10) {
                    im_33.setVisibility(View.INVISIBLE);
                } else if (clickedsecond == 11) {
                    im_34.setVisibility(View.INVISIBLE);
                }else if (clickedsecond == 12) {
                    im_41.setVisibility(View.INVISIBLE);
                } else if (clickedsecond == 13) {
                    im_42.setVisibility(View.INVISIBLE);
                } else if (clickedsecond == 14) {
                    im_43.setVisibility(View.INVISIBLE);
                } else if (clickedsecond == 15) {
                    im_44.setVisibility(View.INVISIBLE);
                } else if (clickedsecond == 16) {
                    im_51.setVisibility(View.INVISIBLE);
                } else if (clickedsecond == 17) {
                    im_52.setVisibility(View.INVISIBLE);
                } else if (clickedsecond == 18) {
                    im_53.setVisibility(View.INVISIBLE);
                } else if (clickedsecond == 19) {
                    im_54.setVisibility(View.INVISIBLE);
                }


                if (turn == 1) {
                    playerPoint++;
                    tvp1.setText("p1 : " + playerPoint);

                } else if (turn == 2) {
                    cpuPoint++;
                    tvp2.setText("p2 : " + cpuPoint);
                }
            }else {
                im_11.setImageResource(R.drawable.back1);
                im_12.setImageResource(R.drawable.back1);
                im_13.setImageResource(R.drawable.back1);
                im_14.setImageResource(R.drawable.back1);
                im_21.setImageResource(R.drawable.back1);
                im_22.setImageResource(R.drawable.back1);
                im_23.setImageResource(R.drawable.back1);
                im_24.setImageResource(R.drawable.back1);
                im_31.setImageResource(R.drawable.back1);
                im_32.setImageResource(R.drawable.back1);
                im_33.setImageResource(R.drawable.back1);
                im_34.setImageResource(R.drawable.back1);
                im_41.setImageResource(R.drawable.back1);
                im_42.setImageResource(R.drawable.back1);
                im_43.setImageResource(R.drawable.back1);
                im_44.setImageResource(R.drawable.back1);
                im_51.setImageResource(R.drawable.back1);
                im_52.setImageResource(R.drawable.back1);
                im_53.setImageResource(R.drawable.back1);
                im_54.setImageResource(R.drawable.back1);

                if (turn == 1) {
                    turn = 2;
                    tvp1.setTextColor(Color.GRAY);
                    tvp2.setTextColor(Color.BLACK);
                } else {
                    turn = 1;
                    tvp1.setTextColor(Color.BLACK);
                    tvp2.setTextColor(Color.GRAY);
                }

            }
            im_11.setEnabled(true);
            im_12.setEnabled(true);
            im_13.setEnabled(true);
            im_14.setEnabled(true);
            im_21.setEnabled(true);
            im_22.setEnabled(true);
            im_23.setEnabled(true);
            im_24.setEnabled(true);
            im_31.setEnabled(true);
            im_32.setEnabled(true);
            im_33.setEnabled(true);
            im_34.setEnabled(true);
            im_41.setEnabled(true);
            im_42.setEnabled(true);
            im_43.setEnabled(true);
            im_44.setEnabled(true);
            im_51.setEnabled(true);
            im_52.setEnabled(true);
            im_53.setEnabled(true);
            im_54.setEnabled(true);

            checkend();
        }

        private void checkend() {
            if (im_11.getVisibility() == View.INVISIBLE
                    && im_12.getVisibility() == View.INVISIBLE
                    && im_13.getVisibility() == View.INVISIBLE
                    && im_14.getVisibility() == View.INVISIBLE
                    && im_21.getVisibility() == View.INVISIBLE
                    && im_22.getVisibility() == View.INVISIBLE
                    && im_23.getVisibility() == View.INVISIBLE
                    && im_24.getVisibility() == View.INVISIBLE
                    && im_31.getVisibility() == View.INVISIBLE
                    && im_32.getVisibility() == View.INVISIBLE
                    && im_33.getVisibility() == View.INVISIBLE
                    && im_34.getVisibility() == View.INVISIBLE
                    && im_41.getVisibility() == View.INVISIBLE
                    && im_42.getVisibility() == View.INVISIBLE
                    && im_43.getVisibility() == View.INVISIBLE
                    && im_44.getVisibility() == View.INVISIBLE
                    && im_51.getVisibility() == View.INVISIBLE
                    && im_52.getVisibility() == View.INVISIBLE
                    && im_53.getVisibility() == View.INVISIBLE
                    && im_54.getVisibility() == View.INVISIBLE
            ) {if(sessionId==2) {
                AlertDialog.Builder alertdialogBuilder = new AlertDialog.Builder(Memory.this);
                alertdialogBuilder
                        .setMessage("Game Over!\nP1:" + playerPoint + "\nP2:" + cpuPoint).setCancelable(false).setPositiveButton("New", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), Memory.class);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                AlertDialog alertDialog = alertdialogBuilder.create();
                alertDialog.show();
            }else{
                AlertDialog.Builder alertdialogBuilder = new AlertDialog.Builder(Memory.this);
                alertdialogBuilder
                        .setMessage("Your score is :" + Counter).setCancelable(false).setPositiveButton("New", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), Memory.class);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                AlertDialog alertDialog = alertdialogBuilder.create();
                alertDialog.show();
            }
            }

        }

        private void frontofthecardsResources() {
            Integer[] size={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
            for(int i=0;i<10;i++){
                int min=100;
                int max=129;
                int random=new Random().nextInt((max - min) + 1) + min;
                if(Arrays.asList(size).contains(random)){
                    i--;}
                else{size[i]=random;}
            }

            for(int i=0;i<10;i++){

                filename="im"+size[i];

                int id=getResources().getIdentifier(filename,"drawable",Memory.this.getPackageName());
                imagearray1[i]=id;
            }

            for(int i=0;i<10;i++){

                filename="im"+size[i];
                int id=getResources().getIdentifier(filename,"drawable",Memory.this.getPackageName());
                imagearray2[i]=id;
            }



        }
    }


