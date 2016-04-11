package com.example.nha_calc;

import android.R.integer;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;


public class MainActivity extends Activity implements OnClickListener {

	Button blimpar;
	EditText inputScreen;
	Button b1,b2,b3, b4 ,b5,b6,b7,b8,b9,b0,
		   bmais,bigual,bmenos,bvezes,bdividir,
		   bponto,bsimetrico,bbackspace,braiz,
		   bmc,bmr,bmmenos,bmmais,bms,
		   binverso,bfact,bquad,bXelavatN,bXsqrtN,
		   bsin,bcos,btan,blog,bln,bexpon,bpi,bpercent;
	Float num1,num2,res,f=(float) 1,pf,memory=(float) 0;
	
 
	String op="",numberDisplayed1="",numberDisplayed2="",nmp1,nmp2;
	Boolean ja_tem_ponto1=false,ja_tem_ponto2=false;
	Boolean erro =  false,flagPer=false;
	ScrollView mScrollView;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        
        if (savedInstanceState != null) {
	        op = (String) savedInstanceState.getSerializable("sop");
	        numberDisplayed1 = (String) savedInstanceState.getSerializable("snumberDisplayed1");
	        numberDisplayed2 = (String) savedInstanceState.getSerializable("snumberDisplayed2");
	        
	        ja_tem_ponto1 = (Boolean) savedInstanceState.getSerializable("sja_tem_ponto1");
	        ja_tem_ponto2 = (Boolean) savedInstanceState.getSerializable("sja_tem_ponto2");
	        erro = (Boolean) savedInstanceState.getSerializable("serro");
	        memory = (Float) savedInstanceState.getSerializable("smemory");
	        
        }   
      
        
        
        inputScreen =(EditText)findViewById(R.id.editText1);
        
        int currentOrientation = getResources().getConfiguration().orientation;
        ////Para garantir que estamos em Portrait
       if (currentOrientation == Configuration.ORIENTATION_PORTRAIT) 
        	{   
 		    	
   	    	   	Log.d("Por","Portrait");
        	}
        else {
		    	
        		braiz=(Button)findViewById(R.id.braiz);
        		braiz.setOnClickListener(this);
        		
        		binverso=(Button)findViewById(R.id.binverso);
        		binverso.setOnClickListener(this);
        		
        		bfact=(Button)findViewById(R.id.bfact);
        		bfact.setOnClickListener(this);
        		
        		bquad=(Button)findViewById(R.id.bquad);
        		bquad.setOnClickListener(this);
        		
        		bXelavatN=(Button)findViewById(R.id.bXelavatN);
        		bXelavatN.setOnClickListener(this);
        		
        		bXsqrtN=(Button)findViewById(R.id.bXsqrtN);
        		bXsqrtN.setOnClickListener(this);
        		
        		bsin=(Button)findViewById(R.id.bsin);
        		bsin.setOnClickListener(this);
        		
        		bcos=(Button)findViewById(R.id.bcos);
        		bcos.setOnClickListener(this);
        		
        		btan=(Button)findViewById(R.id.btan);
        		btan.setOnClickListener(this);
        		
        		blog=(Button)findViewById(R.id.blog);
        		blog.setOnClickListener(this);
        		
        		bln=(Button)findViewById(R.id.bln);
        		bln.setOnClickListener(this);
        		
        		bexpon=(Button)findViewById(R.id.bexpon);
        		bexpon.setOnClickListener(this);
        		
        		bpi=(Button)findViewById(R.id.bpi);
        		bpi.setOnClickListener(this);
        		
        		bpercent=(Button)findViewById(R.id.bpercent);
        		bpercent.setOnClickListener(this);
        	 }
       bmc=(Button)findViewById(R.id.bmc);
       bmc.setOnClickListener(this);
       
       bmmais=(Button)findViewById(R.id.bmmais);
       bmmais.setOnClickListener(this);
       
       bmmenos=(Button)findViewById(R.id.bmmenos);
       bmmenos.setOnClickListener(this);
       
       bmr=(Button)findViewById(R.id.bmr);
       bmr.setOnClickListener(this);
       
       bms=(Button)findViewById(R.id.bms);
       bms.setOnClickListener(this);
       
       blimpar=(Button)findViewById(R.id.blimpar);
	   blimpar.setOnClickListener(this);
	           
	   bmais=(Button)findViewById(R.id.bmais);
	   bmais.setOnClickListener(this);
	   
	   bmenos=(Button)findViewById(R.id.bmenos);
	   bmenos.setOnClickListener(this);
	   
	   bdividir=(Button)findViewById(R.id.bdividir);
	   bdividir.setOnClickListener(this);
	   
	   bvezes=(Button)findViewById(R.id.bvezes);
	   bvezes.setOnClickListener(this);
        
        bigual=(Button)findViewById(R.id.bigual);
	    bigual.setOnClickListener(this);
	    
	    
	    b0=(Button)findViewById(R.id.b0);
	    b0.setOnClickListener(this);
	   
	    b1=(Button)findViewById(R.id.b1);
	    b1.setOnClickListener(this);
	    
	    b2=(Button)findViewById(R.id.b2);
	    b2.setOnClickListener(this);
	   
	    b3=(Button)findViewById(R.id.b3);
	    b3.setOnClickListener(this);
	    
	    b4=(Button)findViewById(R.id.b4);
   	    b4.setOnClickListener(this);
	    
   	    b5=(Button)findViewById(R.id.b5);
   	    b5.setOnClickListener(this);
   	   
   	    b6=(Button)findViewById(R.id.b6);
   	    b6.setOnClickListener(this);
   	    
   	    b7=(Button)findViewById(R.id.b7);
   	    b7.setOnClickListener(this);
   	   
   	    b8=(Button)findViewById(R.id.b8);
   	    b8.setOnClickListener(this);
   	   
   	    b9=(Button)findViewById(R.id.b9);
   	    b9.setOnClickListener(this);
	   
	    bponto=(Button)findViewById(R.id.bponto);
	    bponto.setOnClickListener(this);
	   
	    bsimetrico=(Button)findViewById(R.id.bsimetrico);
	    bsimetrico.setOnClickListener(this);
	   
	    bbackspace=(Button)findViewById(R.id.bbackspace);
	    bbackspace.setOnClickListener(this);
		        
        mScrollView = (ScrollView) findViewById(R.id.SCROLLER_ID);
    }
	
	



	@Override
	public void onClick(View arg0) {
		
		int id=arg0.getId();
		
		switch (id) {			
								
								
								case R.id.blimpar:
								{
									inputScreen.setText("");
									numberDisplayed1="";
									numberDisplayed2="";
									op="";
									ja_tem_ponto1=false;
									ja_tem_ponto2=false;
								break;	
								}
								
								case R.id.bmais:
								{
									if(numberDisplayed1.length()>0 && op=="")
									{
										op="+";
									}	
								break;		
								}
								
								case R.id.bmenos:
								{	if(numberDisplayed1.length()>0 && op=="")
									{
										op="-";
									}	
								break;		
								}
								
								case R.id.bvezes:
								{	if(numberDisplayed1.length()>0 && op=="")
									{
										op="x";
									}	
								break;		
								}
								
								case R.id.bdividir:
								{	
									if(numberDisplayed1.length()>0 && op=="" )
									{
										op="÷";
									}	
								break;		
								}
			//////////////////////OPERAÇÕES MEMORIA////////////////////////////

								case R.id.bmc:
								{ 
									memory=(float) 0;
								break;		
	 							}
								
								case R.id.bmmais:
								{ 
									if(op=="")
										{
											num1=Float.parseFloat(numberDisplayed1);
											memory+=num1;
										}	
								break;		
	 							}
								
								case R.id.bmmenos:
								{ 
									if(op=="")
										{
											num1=Float.parseFloat(numberDisplayed1);
											memory-=num1;
										}	
								break;		
	 							}
								
								case R.id.bms:
								{ 
									if(op=="")
										{
											num1=Float.parseFloat(numberDisplayed1);
											memory=num1;
										}	
								break;		
	 							}
								
								
								
								case R.id.bmr:
								{ 
					
									if(op=="")
										{		
												if(memory!=0)
													{
														numberDisplayed1=""+memory;
													}
										}
									else
										{		
												if(memory!=0)
												{
													numberDisplayed2 = ""+memory;
												}
										}
										
								break;		
	 							}
			//////////////////////OPERAÇÕES MEMORIA////////////////////////////		
					
								
								case R.id.binverso:
								{ 
					
									if(op=="")
										{
											if(numberDisplayed1.length()>0)
												{
													num1=Float.parseFloat(numberDisplayed1);							
													num1=(float)(1/num1);
													numberDisplayed1=""+num1;												
												    if(num1.floatValue()>0){ja_tem_ponto1=true;}
										        }
										}	
									else 
										{
											if(numberDisplayed2.length()>0)
												{
													num2=Float.parseFloat(numberDisplayed2);							
													num2=(float)(1/num2);
													numberDisplayed2=""+num2;												
												    if(num2.floatValue()>0){ja_tem_ponto2=true;}
										        }
										}
								break;		
	 							}
								
								case R.id.bfact:
								{ 
					
									if(op=="")
										{	
											
											num1=Float.parseFloat(numberDisplayed1);
										    	
											if(numberDisplayed1.length()>0 && (num1 - num1.intValue())==0)
												{
												     						
													int n = Integer.parseInt(numberDisplayed1);
													Log.d("N ",""+n);	
													n=fact(n);
													numberDisplayed1=""+n;
													
													
												    
										        }
										}	
									else 
										{
											num2=Float.parseFloat(numberDisplayed2);
											if(numberDisplayed2.length()>0 && (num2 - num2.intValue())==0)
											{
																			
												int n = Integer.parseInt(numberDisplayed2);
												n=fact(n);
												numberDisplayed2=""+n;												
											    
									        }
										}
								break;		
	 							}
								
								
								case R.id.bquad:
								{ 
					
									if(op=="")
										{	
											
											
										    	
											if(numberDisplayed1.length()>0)
												{
												     						
													num1=Float.parseFloat(numberDisplayed1);
													num1=num1*num1;
													numberDisplayed1=""+num1;
													
													
												    
										        }
										}	
									else 
										{
											
											if(numberDisplayed2.length()>0)
											{
																			
												num2=Float.parseFloat(numberDisplayed2);
												num2=num2*num2;
												numberDisplayed2=""+num2;												
											    
									        }
										}
								break;		
	 							}
								
								
								case R.id.bXelavatN:
								{ 
					
										
											
											
										    	
											if(numberDisplayed1.length()>0)
												{
												     						
													num1=Float.parseFloat(numberDisplayed1);
													op="^";
										        }
								break;		
	 							}
								
								
								case R.id.bXsqrtN:
								{ 
					
										
											
											
										    	
											if(numberDisplayed1.length()>0)
												{
												     						
													num1=Float.parseFloat(numberDisplayed1);
													op="v";
										        }
								break;		
	 							}
								
								
								case R.id.braiz:
								{ 
									
									if(op=="")
												{	if(numberDisplayed1.length()>0)
													{
														num1=Float.parseFloat(numberDisplayed1);
														if(num1>=0)
															{
																num1=(float)Math.sqrt(num1);
																numberDisplayed1=""+num1;
																if((num1 - num1.intValue())!=0){ja_tem_ponto1=true;}
														    }
														else 
															{
																
																numberDisplayed1="";
																numberDisplayed2="";
																op="";
																ja_tem_ponto1=false;
																numberDisplayed1="Erro! Raiz Negativo";
															
															}
													}	
												}
									else 
												{	if(numberDisplayed2.length()>0)
													{
														num2=Float.parseFloat(numberDisplayed2);
														if(num2>=0)
															{
																num2=(float)Math.sqrt(num2);
																numberDisplayed2=""+num2;
																if((num2 -num2.intValue())!=0){ja_tem_ponto2=true;}
															 }
														else 
															{
																
																numberDisplayed1="";
																numberDisplayed2="";
																op="";
																ja_tem_ponto2=false;
																numberDisplayed1="Erro! Raiz Negativo";
															
															}
													}
												}
								break;		
			 					}
								
								
								
								
								
			////////////////////////////Numeros//////////////////////////////
								case R.id.b0:
								{ 
					
									if(op==""){numberDisplayed1 += "0";}
									else      {numberDisplayed2 += "0";}
								break;		
	 							}
		
								case R.id.b1:
								{ 
									if(op==""){numberDisplayed1 += "1";}
									else      {numberDisplayed2 += "1";}
								break;		
			 					}
								
								case R.id.b2:
								{ 
									if(op==""){numberDisplayed1 += "2";}
									else      {numberDisplayed2 += "2";}
								break;		
			 					}
								
								case R.id.b3:
								{ 
									if(op==""){numberDisplayed1 += "3";}
									else      {numberDisplayed2 += "3";}
								break;		
			 					}
								
								case R.id.b4:
								{ 
									if(op==""){numberDisplayed1 += "4";}
									else      {numberDisplayed2 += "4";}
								break;		
			 					}
								
								case R.id.b5:
								{ 
									if(op==""){numberDisplayed1 += "5";}
									else      {numberDisplayed2 += "5";}
								break;		
			 					}
								
								case R.id.b6:
								{ 
									if(op==""){numberDisplayed1 += "6";}
									else      {numberDisplayed2 += "6";}
								break;		
			 					}
								
								case R.id.b7:
								{ 
									if(op==""){numberDisplayed1 += "7";}
									else      {numberDisplayed2 += "7";}
								break;		
			 					}
								
								case R.id.b8:
								{ 
									if(op==""){numberDisplayed1 += "8";}
									else      {numberDisplayed2 += "8";}
								break;		
			 					}
								
								case R.id.b9:
								{ 
									if(op==""){numberDisplayed1 += "9";}
									else      {numberDisplayed2 += "9";}
								break;		
			 					}
					/////////////////Numeros/////////////////////////////			
								case R.id.bsimetrico:
								{ 
									
									if(op=="")
												{
													if(numberDisplayed1.length()>0)
													{
														num1=Float.parseFloat(numberDisplayed1);
														num1=(float)num1*(-1);
														numberDisplayed1=""+num1;
													}
												}	
									else 
												{
													if(numberDisplayed2.length()>0)
													{
														num2=Float.parseFloat(numberDisplayed2);
														num2=(float)num2*(-1);
														numberDisplayed2=""+num2;
													}
												}
								break;		
			 					}
								
								case R.id.bbackspace:
								{ 
									
									if(op=="")
												{	if(numberDisplayed1.length()>0)
														{	
															int l=numberDisplayed1.length();
															String mychar = Character.toString(numberDisplayed1.charAt(l-1));
															if(mychar.equals(".")){ja_tem_ponto1=false;}
															numberDisplayed1=numberDisplayed1.substring(0, numberDisplayed1.length()-1);
														}	
												}
									else 
												{	if(numberDisplayed2.length()>0)
														{
															int l=numberDisplayed2.length();
															String mychar = Character.toString(numberDisplayed2.charAt(l-1));
															if(mychar.equals(".")){ja_tem_ponto2=false;}
															numberDisplayed2=numberDisplayed2.substring(0, numberDisplayed2.length()-1);
														}
													else {op="";}
												}
								break;		
			 					}
								
								case R.id.bsin:
								{ 
									
									if(op=="")
												{	
													if(numberDisplayed1.length()>0)
														{
															num1=Float.parseFloat(numberDisplayed1);
															num1=(float)Math.sin(num1);
															numberDisplayed1=""+num1;
															if((num1 - num1.intValue())!=0){ja_tem_ponto1=true;}
														}	
												}
									else 
												{	
													if(numberDisplayed2.length()>0)
														{
															num2=Float.parseFloat(numberDisplayed2);
															num2=(float)Math.sin(num2);
															numberDisplayed2=""+num2;
															if((num2 - num2.intValue())!=0){ja_tem_ponto2=true;}
														}
													}
												
								break;		
			 					}
								
								case R.id.bcos:
								{ 
									
									if(op=="")
												{	
													if(numberDisplayed1.length()>0)
														{
															num1=Float.parseFloat(numberDisplayed1);
															num1=(float)Math.cos(num1);
															numberDisplayed1=""+num1;
															if((num1 - num1.intValue())!=0){ja_tem_ponto1=true;}
														}	
												}
									else 
												{	
													if(numberDisplayed2.length()>0)
														{
															num2=Float.parseFloat(numberDisplayed2);
															num2=(float)Math.cos(num2);
															numberDisplayed2=""+num2;
															if((num2 - num2.intValue())!=0){ja_tem_ponto2=true;}
														}
													}
												
								break;		
			 					}
								
								case R.id.btan:
								{ 
									
									if(op=="")
												{	
													if(numberDisplayed1.length()>0)
														{
															num1=Float.parseFloat(numberDisplayed1);
															num1=(float)Math.tan(num1);
															numberDisplayed1=""+num1;
															if((num1 - num1.intValue())!=0){ja_tem_ponto1=true;}
														}	
												}
									else 
												{	
													if(numberDisplayed2.length()>0)
														{
															num2=Float.parseFloat(numberDisplayed2);
															num2=(float)Math.tan(num2);
															numberDisplayed2=""+num2;
															if((num2 - num2.intValue())!=0){ja_tem_ponto2=true;}
														}
													}
												
								break;		
			 					}
								
								
								case R.id.blog:
								{ 
									
									if(op=="")
												{	
													if(numberDisplayed1.length()>0)
														{
															num1=Float.parseFloat(numberDisplayed1);
															num1=(float)Math.log10(num1);
															numberDisplayed1=""+num1;
															if((num1 - num1.intValue())!=0){ja_tem_ponto1=true;}
														}	
												}
									else 
												{	
													if(numberDisplayed2.length()>0)
														{
															num2=Float.parseFloat(numberDisplayed2);
															num2=(float)Math.log10(num2);
															numberDisplayed2=""+num2;
															if((num2 - num2.intValue())!=0){ja_tem_ponto2=true;}
														}
													}
												
								break;		
			 					}
								
								case R.id.bln:
								{ 
									
									if(op=="")
												{	
													if(numberDisplayed1.length()>0)
														{
															num1=Float.parseFloat(numberDisplayed1);
															num1=(float)Math.log(num1);
															numberDisplayed1=""+num1;
															if((num1 - num1.intValue())!=0){ja_tem_ponto1=true;}
														}	
												}
									else 
												{	
													if(numberDisplayed2.length()>0)
														{
															num2=Float.parseFloat(numberDisplayed2);
															num2=(float)Math.log(num2);
															numberDisplayed2=""+num2;
															if((num2 - num2.intValue())!=0){ja_tem_ponto2=true;}
														}
													}
												
								break;		
			 					}
								
								
								
								
								case R.id.bexpon:
								{ 
									numberDisplayed1="e^";
									op="e";
												
								break;		
			 					}
								
								
								case R.id.bpi:
								{ 
									if(op==""){numberDisplayed1=""+Math.PI;}
									else      {numberDisplayed2=""+Math.PI;}
								break;		
			 					}
								/////////////////////////
								case R.id.bpercent:
								{ 	
									
									flagPer=true;
									if(op=="")
										{
											num1=Float.parseFloat(numberDisplayed1);
											nmp1=numberDisplayed1+"%";
											inputScreen.setText(nmp1);
										}
									else
										{
											num2=Float.parseFloat(numberDisplayed2);
											nmp2=numberDisplayed2+"%";
											inputScreen.setText(nmp2);
										}
									
								break;		
			 					}
								
								
								
								case R.id.bponto:
								{ 
									
										if(op=="")
											 {      
											
													if(numberDisplayed1.length()>0)
														{	
															num1=Float.parseFloat(numberDisplayed1);
															//
															
															
															
															//Significa que o numero ainda não tem ponto flutuante//
															if(ja_tem_ponto1==false)
														    {								
																numberDisplayed1 += ".";
																ja_tem_ponto1=true;
															}
														}	
											 }
										else      
											{		
											
												if(numberDisplayed2.length()>0)
													{	
														num2=Float.parseFloat(numberDisplayed2);
														if(ja_tem_ponto2==false)
														{
															numberDisplayed2 += ".";
															ja_tem_ponto2=true;
														}
											}		 }
								break;		
			 					}
								
								case R.id.bigual:
								{	
									
									if(op!="" && numberDisplayed1.length()>0 && numberDisplayed2.length()>0)
									{	
										//não fazer isso quando for expoente
										if(op!="e")
										{num1=Float.parseFloat(numberDisplayed1);}
										num2=Float.parseFloat(numberDisplayed2);
										
										switch (op.charAt(0)) {
																case '+':
																{	
																	res=f*(num1+num2);
																	
																break;	
																}
																
																case '-':
																{	
																	res=f*(num1-num2); 
																break;	
																}
																
																case 'x':
																{
																	res=f*(num1*num2); 
																break;	
																}
																
																case '÷':
																{	
																	if(num2!=0){
																				res=f*(num1/num2);
																			   }
																	else {
																			erro=true;
																			numberDisplayed1="";
																			numberDisplayed2="";
																			op="";
																			ja_tem_ponto1=false;
																			ja_tem_ponto2=false;
																			numberDisplayed1="Erro! div 0";
																		 }
																break;	
																}
																
																
																case '^':
																{
																	res=(float) (Math.pow(num1, num2)); 
																break;	
																}
																
																case 'v':
																{
																	res=(float) (Math.exp(Math.log(num1)/num2));
																	
																break;	
																}
																
																case 'e':
																{	if(numberDisplayed2.length()>0){
																		num2=Float.parseFloat(numberDisplayed2);
																		res=(float) (Math.exp(num2));
																	}
																break;	
																}
																
																
										                      }	
										
										if(erro==false)
											{	
											
												numberDisplayed1=""+res;
												numberDisplayed2="";
												op="";
												ja_tem_ponto2=false;
												pf=res - res.intValue();
												ja_tem_ponto1=true;
												
												
												
											}
										else erro=false;
											
									break;		
									}
								}
								
				///////////////termino do switch//////////////
								
								
									
					}
					
			//SE HOUVER UM MEMORIA ENTÃO MOSTRA m senão não mostra
					if(memory!=0 && erro==false)
						{	
								
							if(flagPer==true)
								{
									if(op=="")
										{
											num1=Float.parseFloat(numberDisplayed1);
											inputScreen.setText(numberDisplayed1+"%"+op+numberDisplayed2);
											flagPer=false;
											res=(num1/100)*num2;
										}
									else
										{
											num1=Float.parseFloat(numberDisplayed1);
											inputScreen.setText(numberDisplayed1+op+numberDisplayed2+"%");
											flagPer=false;
											
											res=num1*(num2/100);
										}
									
									
									
								}	
						
						
							//se vier do expoente
							if(op!="e")
								{
									inputScreen.setText("m      "+numberDisplayed1+op+numberDisplayed2);
								}
							
							else {
									inputScreen.setText("m      "+numberDisplayed1+numberDisplayed2);
								 }
						   }
					
					else 
						{  
							if(op!="e")
								{
									inputScreen.setText(numberDisplayed1+op+numberDisplayed2);
								}
							else
								{
									inputScreen.setText(numberDisplayed1+numberDisplayed2);
								}
						
						}
					
					
					
					
		mScrollView.post(new Runnable() {
		    @Override

		    public void run() {

		    	mScrollView.scrollTo(0, mScrollView.getBottom());

		    }
		});
		
	}
	
	
	private int fact(int x) {
		if (x==0) {return 1;}
		else {return x*(fact (x-1));}
	}





	private void scrollToBottom()
    {
        mScrollView.post(new Runnable()
        { 
            public void run()
            { 
                mScrollView.smoothScrollTo(0, inputScreen.getBottom());
                mScrollView.fullScroll(View.FOCUS_DOWN);
            } 
        });
        
     }
	
	
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putSerializable("sop", op);
		outState.putSerializable("snumberDisplayed1", numberDisplayed1);
		outState.putSerializable("snumberDisplayed2", numberDisplayed2);
		outState.putSerializable("sja_tem_ponto1", ja_tem_ponto1);
		outState.putSerializable("sja_tem_ponto2", ja_tem_ponto2);
		outState.putSerializable("serro", erro);
		outState.putSerializable("smemory", memory);

		//Toast.makeText(this, "History saved.", Toast.LENGTH_SHORT).show();
	}
	
	





  
	
	

		
	




    
}
