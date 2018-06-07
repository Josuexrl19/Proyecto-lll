package domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import static java.lang.Thread.sleep;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class RunningImage {
    
    int min = 0, sec = 0;
    int matrizCaminos [][];
    int moveColumna=0;
    int moveFila;
    int initX;
    int initY;
    int topeFila;
    int topeColumna;
    
    public void runImage1 (Graphics g, BufferedImage bufferedPersonaje1, int [][] matrizOfWall, int typeSpeed,
            JLabel lb_win1, JLabel lb_win2, JLabel lb_win3, JLabel lb_win4, JComboBox combo){
        
        new Thread(){
        public void run(){
     
            if (combo.getSelectedIndex()==0) {
                matrizCaminos=new int[10][10];
                moveFila=7;
                initX=250;
                initY=500;
                topeFila = 10;
                topeColumna = 10 ;
            }
            else if (combo.getSelectedIndex()==1) {
                matrizCaminos=new int[10][14];
                moveFila=7;
                initX=250;
                initY=500;
                topeFila = 10;
                topeColumna = 14;
            }
            else if (combo.getSelectedIndex()==2) {
                matrizCaminos= new int[11][18];
                moveFila=7;
                initX=150;
                initY=500;
                topeFila = 11;
                topeColumna = 18;
            }
            
            int second = 0;
            int speed = 800;
            
            int moveAux=moveFila;
            Boolean callejonRecto=false;
            Boolean callejonReversa=false;
            Boolean callejonSubiendo=false;
            Boolean callejonBajando=false;
            Boolean decisions=false;
            Boolean debeVolver=false;
            boolean primerIngreso=true;
            boolean exitvalidation = true;
            while(exitvalidation){
                
                if (typeSpeed==1) {
                    
                    try{
                        Thread.sleep(500);    
                        second++;  
                        if (second>=0 && second<=10) {
                            speed=-900;
                        
                        }if (second>=10 && second<=15) {
                            Thread.sleep(999);
                            speed=800;
                            if (second>=15){
                                second=0;
                            }
                        }
                        

                    }catch(Exception e){}
                }
                
                if (typeSpeed==2) {
                    speed=1200;
                }
                if (matrizOfWall[moveFila][moveColumna]==8) {
                    exitvalidation=false;
                    if (lb_win1.getText().equals("")) {
                        lb_win1.setText("List of Winners : 1) Red Bug");
                    }else if (lb_win2.getText().equals("")) {
                        lb_win2.setText("2) Red Bug");
                    }else if (lb_win3.getText().equals("")) {
                        lb_win3.setText("3) Red Bug");
                    }else if (lb_win4.getText().equals("")) {
                        lb_win4.setText("4) Red Bug");
                    }
                }               
                //para devolverse en el callejon 
                if(debeVolver==true){
                    matrizCaminos= new int[10][10];
                    debeVolver=false;
                }else{     
                //cuando se mete por primera ves 
                if (primerIngreso) {
                    if(matrizOfWall[moveFila][moveColumna]!=1 && initX<300 && matrizCaminos[moveFila][moveColumna]!=1){
                    
                        g.clearRect( initX, initY+10, 30, 30);
                        initX+=50;
                        g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                        matrizCaminos[moveFila][moveColumna]=1;
                        moveColumna++;
                        primerIngreso=false;
                        }// fin del if 
                 }else if (moveFila==0) {
                    if (moveColumna==topeColumna) {
                        if (matrizOfWall[moveFila+1][moveColumna-1]!=1 && matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                                matrizCaminos[moveFila+1][moveColumna-1]=1;
                                moveFila++;
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initY+=50;
                                g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                        }else if (matrizOfWall[moveFila][moveColumna-2]!=1 && matrizCaminos[moveFila][moveColumna-2]!=1) {
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX-=50;
                                g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna-2]=1;
                               moveColumna--;
                        }else {
                            debeVolver=true;}
                    }

                    else if (matrizCaminos[moveFila][moveColumna]!=1 || matrizCaminos[moveFila][moveColumna-2]!=1 || matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                        //pregunta si al frente hay muro o si no ha pasado
                        if (matrizOfWall[moveFila][moveColumna]!=1 && matrizCaminos[moveFila][moveColumna]!=1) {
                                //para adelante
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX+=50;
                                g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna]=1;
                                moveColumna++;
                        }
                        else if (matrizOfWall[moveFila][moveColumna-2]!=1 && matrizCaminos[moveFila][moveColumna-2]!=1) {
                                //va para atras
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX-=50;
                                g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna-2]=1;
                               moveColumna--;
                        }
                        else if (matrizOfWall[moveFila+1][moveColumna-1]!=1 && matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                                //va para abajo
                                matrizCaminos[moveFila+1][moveColumna-1]=1;
                                moveFila++;
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initY+=50;
                                g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                               
                            

                        }
                        else{
                        debeVolver=true;
                       
                        }
                        
                        
                        
                        
                    }
    
                    
                }
                else if (moveFila==topeFila-1) {
                    
                     if (moveColumna==topeColumna-1) {
                           if (matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                                matrizCaminos[moveFila-1][moveColumna-1]=1;
                                moveFila--;
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initY-=50;
                                g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                        }
                        else if (matrizOfWall[moveFila][moveColumna-2]!=1 && matrizCaminos[moveFila][moveColumna-2]!=1) {
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX-=50;
                                g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna-2]=1;
                               moveColumna--;
                        }
                        else{
                            debeVolver=true;
                        }
                    }
                    else if (matrizCaminos[moveFila][moveColumna]!=1 || matrizCaminos[moveFila][moveColumna-2]!=1 || matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                        
                        if (matrizOfWall[moveFila][moveColumna]!=1 && matrizCaminos[moveFila][moveColumna]!=1) {
                                //para adelante
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX+=50;
                                g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna]=1;
                                
                                moveColumna++;
                                
                        }
                        else if (matrizOfWall[moveFila][moveColumna-2]!=1 && matrizCaminos[moveFila][moveColumna-2]!=1) {
                                //va para atras
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX-=50;
                                g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                                callejonRecto=true;
                                matrizCaminos[moveFila][moveColumna-2]=1;
                               moveColumna--;
                        }
                        else if (matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                            //va para arriba
                            matrizCaminos[moveFila-1][moveColumna-1]=1;
                            moveFila--;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY-=50;
                            g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);

                        }else{
                              debeVolver=true;
                              
                        }
                          
                          
                          
                          
                    }  
                }
                else if (moveColumna==0) {
                      if (matrizCaminos[moveFila][moveColumna]!=1 || matrizCaminos[moveFila-1][moveColumna-1]!=1 || matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                        
                        if (matrizOfWall[moveFila][moveColumna]!=1 && matrizCaminos[moveFila][moveColumna]!=1) {
                                //para adelante
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX+=50;
                                g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna]=1;
                                moveColumna++;   
                        }
                        else if (matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                            //va para arriba
                            matrizCaminos[moveFila-1][moveColumna-1]=1;
                            moveFila--;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY-=50;
                            g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);

                        }
                        else if (matrizOfWall[moveFila+1][moveColumna-1]!=1 && matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                            //va para abajo
                            matrizCaminos[moveFila+1][moveColumna-1]=1;
                            moveFila++;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY+=50;
                            g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                        }
                        else{
                            debeVolver=true;
                            
                        }
                          
                        
                      }
                    
                    }
                else if (moveColumna==topeColumna) {
                      if (matrizCaminos[moveFila][moveColumna-2]!=1 || matrizCaminos[moveFila-1][moveColumna-1]!=1 || matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                        
                          if (matrizOfWall[moveFila][moveColumna-2]!=1 && matrizCaminos[moveFila][moveColumna-2]!=1) {
                                //va para atras
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX-=50;
                                g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna-2]=1;
                                moveColumna--;
                        }
                        else if (matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                            //va para arriba
                            matrizCaminos[moveFila-1][moveColumna-1]=1;
                            moveFila--;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY-=50;
                            g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);

                        }
                        else if (matrizOfWall[moveFila+1][moveColumna-1]!=1 && matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                            //va para abajo
                            moveFila++;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY+=50;
                            g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                            
                        }
                        else{
                            debeVolver=true;
                            
                        
                        }
                          
                          
                          
                          
                    }  
                    }
                //avanzando en linea recta
                else if (matrizOfWall[moveFila][moveColumna]!=1 && matrizCaminos[moveFila][moveColumna]!=1 && matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                     int decision= (int)(Math.random()*2);
                     if (decision==0) {
                        //quiso irse por arriba
                                matrizCaminos[moveFila-1][moveColumna-1]=1;
                                moveFila--;
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initY-=50;
                                g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                    }
                     else{
                         //quiso irse por linea recta
                         g.clearRect( initX, initY+10, 30, 30);
                        g.setColor(Color.BLACK);
                        g.drawRect(initX, initY, 50, 50);
                        initX+=50;
                        g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                        matrizCaminos[moveFila][moveColumna]=1;
                        moveColumna++;
                     }
   
                    }
                else if(matrizOfWall[moveFila][moveColumna]!=1 && matrizCaminos[moveFila][moveColumna]!=1){
                    g.clearRect( initX, initY+10, 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(initX, initY, 50, 50);
                    initX+=50;
                    g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                    matrizCaminos[moveFila][moveColumna]=1;
                    moveColumna++;
                }
                //cuando avanzando en linea recta encontro un callejonRecto
                else if (matrizOfWall[moveFila][moveColumna]==1 && matrizOfWall[moveFila-1][moveColumna-1]==1 && matrizOfWall[moveFila+1][moveColumna-1]==1) {
                    //va para atras
                    g.clearRect( initX, initY+10, 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(initX, initY, 50, 50);
                    initX-=50;
                    g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                    callejonRecto=true;
                    matrizCaminos[moveFila][moveColumna-2]=1;
                   moveColumna--;
                }
                //cuando debera buscar otro camino porque no es un callejon y encontro un muro
                else{
                        //este para que el vaya subiendo recto hasta que encuentre una salida(sube y sube )
                    if (matrizOfWall[moveFila-1][moveColumna]==1||matrizOfWall[moveFila+1][moveColumna]==1) {
                        decisions=true;

                        int decision= (int)(Math.random()*2);
                        if (decision==0) {
                            //vamos para arriba
                            while(decisions){
                                if (moveFila==0) {
                                    if (matrizOfWall[moveFila][moveColumna-2]==1 && matrizOfWall[moveFila][moveColumna]==1) {
                                       
                                    }
                                    decisions=false;
                                }
                                else if (matrizOfWall[moveFila-1][moveColumna-1]==1&&matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                                    decisions=false;
                                }  
                                
                                else if(matrizOfWall[moveFila-1][moveColumna-1]==1 && matrizCaminos[moveFila+1][moveColumna-1]==1){
                                    //choco con un muro por el frente y por arriba, por el cual debe caminar hacia la izquierda para buscar una por arriba y sino devuelva por donde viene
                                    if (matrizCaminos[moveFila][moveColumna-2]!=1 && matrizOfWall[moveFila][moveColumna-2]!=1) {
                                        
                                                Boolean marchaAtras=true;
                                                
                                                while(marchaAtras){
                                                    if (moveColumna-1==0) {
                                                       decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                }     
                                                    else if (matrizOfWall[moveFila-1][moveColumna-2]!=1&&matrizCaminos[moveFila-1][moveColumna-2]!=1 && matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                        //encontro una salida por un posicion atras y por arriba
                                                        
                                                        matrizCaminos[moveFila][moveColumna-2]=1;
                                                        moveColumna--;
                                                        g.clearRect( initX, initY+10, 30, 30);
                                                        g.setColor(Color.BLACK);
                                                        g.drawRect(initX, initY, 50, 50);
                                                        initX-=50;
                                                        g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                                       
                                                        decisions=false;
                                                        marchaAtras=false;
                                                }
                                                else{
                                                    if (matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                            
                                                            matrizCaminos[moveFila][moveColumna-2]=1;
                                                            moveColumna--;
                                                            g.clearRect( initX, initY+10, 30, 30);
                                                            g.setColor(Color.BLACK);
                                                            g.drawRect(initX, initY, 50, 50);
                                                            initX-=50;
                                                            g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                                                    }
                                                    else{ 
                                                        decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                        
                                                    }
                                                    
                                                    }
                                                    try{
                                                        sleep(200);
                                                    }
                                                    catch(Exception ex){
                                                    
                                                    }
                                                }//fin del while marcha atras 
                                        
                                    }
                                    else{
                                        decisions=false;
                                        debeVolver=true;
                                    }
                                   
                                    
                                     
                                }
                                //pregunta el bloque de arriba que esta en el frente esta vacio y que si arriba de donde esta no ha pasado
                                else if (matrizOfWall[moveFila-1][moveColumna]==1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                                    matrizCaminos[moveFila-1][moveColumna-1]=1;
                                    moveFila--;
                                    g.clearRect( initX, initY+10, 30, 30);
                                    g.setColor(Color.BLACK);
                                    g.drawRect(initX, initY, 50, 50);
                                    initY-=50;
                                    g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                                    

                                }
                                else{
                                    //solamente si no ha pasado por arriba puede subir
                                    if (matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                                         moveFila--;
                                        g.clearRect( initX, initY+10, 30, 30);
                                        g.setColor(Color.BLACK);
                                        g.drawRect(initX, initY, 50, 50);
                                        initY-=50;
                                        g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                                        decisions=false;
                                    }
                                    
                                    //como aqui ya subio hay que buscar otras alternativas ya sea para atras o saber que entro en un callejon y debemos devolvernos por donde ya pasamos
                                    else{
                                        //pregunta si esta en la ultima posicion de la columna para que no vaya mas para atras
                                        if (moveColumna-1==0) {
                                            //esta metido en un callejon y ya llego a la primer columna por lo tanto devuelvase;
                                            decisions=false;
                                            debeVolver=true;
                                        }
                                        else if (matrizCaminos[moveFila][moveColumna-2]!=1) {
                                            //aquiiiiii
                                            if (moveFila==0) {
                                                if (matrizOfWall[moveFila-1][moveColumna-2]!=1&&matrizCaminos[moveFila-1][moveColumna-2]!=1) {
                                                    decisions=false;
                                                }
                                            }
                                            
                                            else{
                                                
                                                Boolean marchaAtras=true;
                                                while(marchaAtras){
                                                if (moveColumna-1==0) {
                                                       decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                }     
                                                else if (matrizOfWall[moveFila-1][moveColumna-2]!=1&&matrizCaminos[moveFila-1][moveColumna-2]!=1) {
                                                    decisions=false;
                                                    marchaAtras=false;
                                                }
                                                else{
                                                    if (matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                        matrizCaminos[moveFila][moveColumna-2]=1;
                                                        moveColumna--;
                                                        g.clearRect( initX, initY+10, 30, 30);
                                                        g.setColor(Color.BLACK);
                                                        g.drawRect(initX, initY, 50, 50);
                                                        initX-=50;
                                                        g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                                                    }
                                                    else{ 
                                                        decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                        
                                                    }
                                                    
                                                    }
                                                    try{
                                                        sleep(200);
                                                    }
                                                    catch(Exception ex){
                                                    
                                                    }
                                                } 
                                            }
                                                
                                            
                                           
                                        }
                                        else{
                                        
                                        }
                                        //
                                    }   
                                   
                                    
                                }
                            try{
                                sleep(500);
                            }catch(Exception ex){}
                            }
                        }//fin if de decisiones seria aqui un 1
                        else{
                            //vamos para abajo
                            while(decisions){
                                if (moveFila==topeFila-1 ) {
                                    if (matrizOfWall[moveFila][moveColumna-2]==1 && matrizOfWall[moveFila][moveColumna]==1) {
                                    }
                                    decisions=false;
                                }
                                else if (matrizOfWall[moveFila+1][moveColumna-1]==1&&matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                                    decisions=false;
                                } 
                                
                                else if(matrizOfWall[moveFila+1][moveColumna-1]==1&&matrizCaminos[moveFila-1][moveColumna-1]==1){
                                    //choco con un muro por el frente y por arriba, por el cual debe caminar hacia la izquierda para buscar una por arriba y sino devuelva por donde viene
                                    if (matrizCaminos[moveFila][moveColumna-2]!=1 &&matrizOfWall[moveFila][moveColumna-2]!=1) {
                                        
                                                Boolean marchaAtras=true;
                                                
                                                while(marchaAtras){
                                                    if (moveColumna-1==0) {
                                                       decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                }     
                                                    else if (matrizOfWall[moveFila+1][moveColumna-2]!=1&&matrizCaminos[moveFila+1][moveColumna-2]!=1 && matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                        //encontro una salida por un posicion atras y por arriba
                                                        
                                                        matrizCaminos[moveFila][moveColumna-2]=1;
                                                        moveColumna--;
                                                        g.clearRect( initX, initY+10, 30, 30);
                                                        g.setColor(Color.BLACK);
                                                        g.drawRect(initX, initY, 50, 50);
                                                        initX-=50;
                                                        g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                                       
                                                        decisions=false;
                                                        marchaAtras=false;
                                                }
                                                else{
                                                    if (matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                            
                                                            matrizCaminos[moveFila][moveColumna-2]=1;
                                                            moveColumna--;
                                                            g.clearRect( initX, initY+10, 30, 30);
                                                            g.setColor(Color.BLACK);
                                                            g.drawRect(initX, initY, 50, 50);
                                                            initX-=50;
                                                            g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                                                    }
                                                    else{ 
                                                        decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                        
                                                    }
                                                    
                                                    }
                                                    try{
                                                        sleep(200);
                                                    }
                                                    catch(Exception ex){
                                                    
                                                    }
                                                }//fin del while marcha atras 
                                        
                                    }
                                    else{
                                        decisions=false;
                                        debeVolver=true;
                                    }
                                   
                                    
                                     
                                }
                                else if (matrizOfWall[moveFila+1][moveColumna]==1) {
                                    matrizCaminos[moveFila+1][moveColumna-1]=1;
                                    moveFila++;
                                    g.clearRect( initX, initY+10, 30, 30);
                                    g.setColor(Color.BLACK);
                                    g.drawRect(initX, initY, 50, 50);
                                    initY+=50;
                                    g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                                    
                                }
                                else{
                                    if (matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                                        //va para abajo
                                        moveFila++;
                                        g.clearRect( initX, initY+10, 30, 30);
                                        g.setColor(Color.BLACK);
                                        g.drawRect(initX, initY, 50, 50);
                                        initY+=50;
                                        g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                                        decisions=false;
                                    }
                                    else{
                                        //solamente si no ha subido puede bajar
                                        if (matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                                             moveFila--;
                                            g.clearRect( initX, initY+10, 30, 30);
                                            g.setColor(Color.BLACK);
                                            g.drawRect(initX, initY, 50, 50);
                                            initY-=50;
                                            g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                                            decisions=false;
                                    }
                                        else{
                                            if (matrizCaminos[moveFila][moveColumna-2]!=1) {
                                                if (moveFila==0) {
                                                    if (matrizOfWall[moveFila+1][moveColumna-2]!=1 && matrizCaminos[moveFila+1][moveColumna-2]!=1) {
                                                        decisions=false;
                                                    }
                                                    else{
                                                        Boolean marchaAtras=true;
                                                        while(marchaAtras){
                                                        if (moveColumna-1==0) {
                                                               decisions=false;
                                                                marchaAtras=false;
                                                                debeVolver=true;
                                                        }     
                                                        else if (matrizOfWall[moveFila+1][moveColumna-2]!=1&&matrizCaminos[moveFila+1][moveColumna-2]!=1) {
                                                            decisions=false;
                                                            marchaAtras=false;
                                                        }
                                                        else{
                                                            if (matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                                    matrizCaminos[moveFila][moveColumna-2]=1;
                                                                    moveColumna++;
                                                                    g.clearRect( initX, initY+10, 30, 30);
                                                                    g.setColor(Color.BLACK);
                                                                    g.drawRect(initX, initY, 50, 50);
                                                                    initX+=50;
                                                                    g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                                                            }
                                                            else{ 
                                                                decisions=false;
                                                                marchaAtras=false;
                                                                debeVolver=true;

                                                            }

                                                            }
                                                            try{
                                                                sleep(200);
                                                            }
                                                            catch(Exception ex){

                                                            }
                                                        } 
                                                    
                                                    
                                                    
                                                    }
                                                    
                                                }
                                            else if ((matrizOfWall[moveFila-1][moveColumna-2]!=1&&matrizCaminos[moveFila-1][moveColumna-2]!=1) || (matrizOfWall[moveFila+1][moveColumna-2]!=1&&matrizCaminos[moveFila+1][moveColumna-2]!=1)) {
                                                //metase por ahi
                                                decisions=false;
                                            }
                                            else{
                                                
                                            matrizCaminos[moveFila][moveColumna-2]=1;
                                            moveColumna--;
                                            g.clearRect( initX, initY+10, 30, 30);
                                            g.setColor(Color.BLACK);
                                            g.drawRect(initX, initY, 50, 50);
                                            initX-=50;
                                            g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                                            }
//                                                JOptionPane.showMessageDialog(null, "El toque es que si tiene que aplicar reversa");
                                            }
                                        
                                        
                                        }
                                        //JOptionPane.showMessageDialog(null, "no puedo pasar donde ya pase");
                                    
                                    }
                                   
                                }
                            try{
                                sleep(500);
                            }catch(Exception ex){}
                            }
                    }
                    }
                    else{
                        int decision= (int)(Math.random()*2);
                        if (decision==0) {
                            if (matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                                matrizCaminos[moveFila-1][moveColumna-1]=1;
                                moveFila--;
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initY-=50;
                                g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                    }
                    }
                    else{
                        if (matrizOfWall[moveFila+1][moveColumna-1]!=1 && matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                            matrizCaminos[moveFila+1][moveColumna-1]=1;
                            moveFila++;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY+=50;
                            g.drawImage(bufferedPersonaje1, initX, initY+10, 30, 30, null);
                    }
                    }          
                    }
                }
                }
                try{
                    sleep(500);
                }catch(Exception ex){}
            }
        }
    }.start();
}   
  
        
        
    
    public void runImage2 (Graphics g, BufferedImage bufferedPersonaje2, int [][] matrizOfWall, int typeSpeed,
            JLabel lb_win1, JLabel lb_win2, JLabel lb_win3, JLabel lb_win4, JComboBox combo){
        
        new Thread(){
        public void run(){
     
            if (combo.getSelectedIndex()==0) {
                matrizCaminos=new int[10][10];
                moveFila=6;
                initX=250;
                initY=450;
                topeFila = 10;
                topeColumna = 10 ;
            }
            else if (combo.getSelectedIndex()==1) {
                matrizCaminos=new int[10][14];
                moveFila=6;
                initX=250;
                initY=450;
                topeFila = 10;
                topeColumna = 14;
            }
            else if (combo.getSelectedIndex()==2) {
                matrizCaminos= new int[11][18];
                moveFila=6;
                initX=150;
                initY=450;
                topeFila = 11;
                topeColumna = 18;
            }
            
            int second = 0;
            int speed = 800;
            
            int moveAux=moveFila;
            Boolean callejonRecto=false;
            Boolean callejonReversa=false;
            Boolean callejonSubiendo=false;
            Boolean callejonBajando=false;
            Boolean decisions=false;
            Boolean debeVolver=false;
            boolean primerIngreso=true;
            boolean exitvalidation = true;
            while(exitvalidation){
                
                if (typeSpeed==1) {
                    
                    try{
                        Thread.sleep(500);    
                        second++;  
                        if (second>=0 && second<=10) {
                            speed=-900;
                        
                        }if (second>=10 && second<=15) {
                            Thread.sleep(999);
                            speed=800;
                            if (second>=15){
                                second=0;
                            }
                        }
                        

                    }catch(Exception e){}
                }
                
                if (typeSpeed==2) {
                    speed=1200;
                }
                if (matrizOfWall[moveFila][moveColumna]==8) {
                    exitvalidation=false;
                    if (lb_win1.getText().equals("")) {
                        lb_win1.setText("List of Winners : 1) Pink Bug");
                    }else if (lb_win2.getText().equals("")) {
                        lb_win2.setText("2) Pink Bug");
                    }else if (lb_win3.getText().equals("")) {
                        lb_win3.setText("3) Pink Bug");
                    }else if (lb_win4.getText().equals("")) {
                        lb_win4.setText("4) Pink Bug");
                    }
                }               
                //para devolverse en el callejon 
                if(debeVolver==true){
                    matrizCaminos= new int[10][10];
                    debeVolver=false;
                }else{     
                //cuando se mete por primera ves 
                if (primerIngreso) {
                    if(matrizOfWall[moveFila][moveColumna]!=1 && initX<300 && matrizCaminos[moveFila][moveColumna]!=1){
                    
                        g.clearRect( initX, initY+10, 30, 30);
                        initX+=50;
                        g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                        matrizCaminos[moveFila][moveColumna]=1;
                        moveColumna++;
                        primerIngreso=false;
                        }// fin del if 
                 }else if (moveFila==0) {
                    if (moveColumna==topeColumna) {
                        if (matrizOfWall[moveFila+1][moveColumna-1]!=1 && matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                                matrizCaminos[moveFila+1][moveColumna-1]=1;
                                moveFila++;
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initY+=50;
                                g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                        }else if (matrizOfWall[moveFila][moveColumna-2]!=1 && matrizCaminos[moveFila][moveColumna-2]!=1) {
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX-=50;
                                g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna-2]=1;
                               moveColumna--;
                        }else {
                            debeVolver=true;}
                    }

                    else if (matrizCaminos[moveFila][moveColumna]!=1 || matrizCaminos[moveFila][moveColumna-2]!=1 || matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                        //pregunta si al frente hay muro o si no ha pasado
                        if (matrizOfWall[moveFila][moveColumna]!=1 && matrizCaminos[moveFila][moveColumna]!=1) {
                                //para adelante
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX+=50;
                                g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna]=1;
                                moveColumna++;
                        }
                        else if (matrizOfWall[moveFila][moveColumna-2]!=1 && matrizCaminos[moveFila][moveColumna-2]!=1) {
                                //va para atras
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX-=50;
                                g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna-2]=1;
                               moveColumna--;
                        }
                        else if (matrizOfWall[moveFila+1][moveColumna-1]!=1 && matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                                //va para abajo
                                matrizCaminos[moveFila+1][moveColumna-1]=1;
                                moveFila++;
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initY+=50;
                                g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                               
                            

                        }
                        else{
                        debeVolver=true;
                       
                        }
                        
                        
                        
                        
                    }
    
                    
                }
                else if (moveFila==topeFila-1) {
                    
                     if (moveColumna==topeColumna-1) {
                           if (matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                                matrizCaminos[moveFila-1][moveColumna-1]=1;
                                moveFila--;
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initY-=50;
                                g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                        }
                        else if (matrizOfWall[moveFila][moveColumna-2]!=1 && matrizCaminos[moveFila][moveColumna-2]!=1) {
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX-=50;
                                g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna-2]=1;
                               moveColumna--;
                        }
                        else{
                            debeVolver=true;
                        }
                    }
                    else if (matrizCaminos[moveFila][moveColumna]!=1 || matrizCaminos[moveFila][moveColumna-2]!=1 || matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                        
                        if (matrizOfWall[moveFila][moveColumna]!=1 && matrizCaminos[moveFila][moveColumna]!=1) {
                                //para adelante
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX+=50;
                                g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna]=1;
                                
                                moveColumna++;
                                
                        }
                        else if (matrizOfWall[moveFila][moveColumna-2]!=1 && matrizCaminos[moveFila][moveColumna-2]!=1) {
                                //va para atras
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX-=50;
                                g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                                callejonRecto=true;
                                matrizCaminos[moveFila][moveColumna-2]=1;
                               moveColumna--;
                        }
                        else if (matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                            //va para arriba
                            matrizCaminos[moveFila-1][moveColumna-1]=1;
                            moveFila--;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY-=50;
                            g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);

                        }else{
                              debeVolver=true;
                              
                        }
                          
                          
                          
                          
                    }  
                }
                else if (moveColumna==0) {
                      if (matrizCaminos[moveFila][moveColumna]!=1 || matrizCaminos[moveFila-1][moveColumna-1]!=1 || matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                        
                        if (matrizOfWall[moveFila][moveColumna]!=1 && matrizCaminos[moveFila][moveColumna]!=1) {
                                //para adelante
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX+=50;
                                g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna]=1;
                                moveColumna++;   
                        }
                        else if (matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                            //va para arriba
                            matrizCaminos[moveFila-1][moveColumna-1]=1;
                            moveFila--;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY-=50;
                            g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);

                        }
                        else if (matrizOfWall[moveFila+1][moveColumna-1]!=1 && matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                            //va para abajo
                            matrizCaminos[moveFila+1][moveColumna-1]=1;
                            moveFila++;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY+=50;
                            g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                        }
                        else{
                            debeVolver=true;
                            
                        }
                          
                        
                      }
                    
                    }
                else if (moveColumna==topeColumna) {
                      if (matrizCaminos[moveFila][moveColumna-2]!=1 || matrizCaminos[moveFila-1][moveColumna-1]!=1 || matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                        
                          if (matrizOfWall[moveFila][moveColumna-2]!=1 && matrizCaminos[moveFila][moveColumna-2]!=1) {
                                //va para atras
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX-=50;
                                g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna-2]=1;
                                moveColumna--;
                        }
                        else if (matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                            //va para arriba
                            matrizCaminos[moveFila-1][moveColumna-1]=1;
                            moveFila--;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY-=50;
                            g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);

                        }
                        else if (matrizOfWall[moveFila+1][moveColumna-1]!=1 && matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                            //va para abajo
                            moveFila++;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY+=50;
                            g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                            
                        }
                        else{
                            debeVolver=true;
                            
                        
                        }
                          
                          
                          
                          
                    }  
                    }
                //avanzando en linea recta
                else if (matrizOfWall[moveFila][moveColumna]!=1 && matrizCaminos[moveFila][moveColumna]!=1 && matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                     int decision= (int)(Math.random()*2);
                     if (decision==0) {
                        //quiso irse por arriba
                                matrizCaminos[moveFila-1][moveColumna-1]=1;
                                moveFila--;
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initY-=50;
                                g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                    }
                     else{
                         //quiso irse por linea recta
                         g.clearRect( initX, initY+10, 30, 30);
                        g.setColor(Color.BLACK);
                        g.drawRect(initX, initY, 50, 50);
                        initX+=50;
                        g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                        matrizCaminos[moveFila][moveColumna]=1;
                        moveColumna++;
                     }
   
                    }
                else if(matrizOfWall[moveFila][moveColumna]!=1 && matrizCaminos[moveFila][moveColumna]!=1){
                    g.clearRect( initX, initY+10, 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(initX, initY, 50, 50);
                    initX+=50;
                    g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                    matrizCaminos[moveFila][moveColumna]=1;
                    moveColumna++;
                }
                //cuando avanzando en linea recta encontro un callejonRecto
                else if (matrizOfWall[moveFila][moveColumna]==1 && matrizOfWall[moveFila-1][moveColumna-1]==1 && matrizOfWall[moveFila+1][moveColumna-1]==1) {
                    //va para atras
                    g.clearRect( initX, initY+10, 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(initX, initY, 50, 50);
                    initX-=50;
                    g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                    callejonRecto=true;
                    matrizCaminos[moveFila][moveColumna-2]=1;
                   moveColumna--;
                }
                //cuando debera buscar otro camino porque no es un callejon y encontro un muro
                else{
                        //este para que el vaya subiendo recto hasta que encuentre una salida(sube y sube )
                    if (matrizOfWall[moveFila-1][moveColumna]==1||matrizOfWall[moveFila+1][moveColumna]==1) {
                        decisions=true;

                        int decision= (int)(Math.random()*2);
                        if (decision==0) {
                            //vamos para arriba
                            while(decisions){
                                if (moveFila==0) {
                                    if (matrizOfWall[moveFila][moveColumna-2]==1 && matrizOfWall[moveFila][moveColumna]==1) {
                                       
                                    }
                                    decisions=false;
                                }
                                else if (matrizOfWall[moveFila-1][moveColumna-1]==1&&matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                                    decisions=false;
                                }  
                                
                                else if(matrizOfWall[moveFila-1][moveColumna-1]==1 && matrizCaminos[moveFila+1][moveColumna-1]==1){
                                    //choco con un muro por el frente y por arriba, por el cual debe caminar hacia la izquierda para buscar una por arriba y sino devuelva por donde viene
                                    if (matrizCaminos[moveFila][moveColumna-2]!=1 && matrizOfWall[moveFila][moveColumna-2]!=1) {
                                        
                                                Boolean marchaAtras=true;
                                                
                                                while(marchaAtras){
                                                    if (moveColumna-1==0) {
                                                       decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                }     
                                                    else if (matrizOfWall[moveFila-1][moveColumna-2]!=1&&matrizCaminos[moveFila-1][moveColumna-2]!=1 && matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                        //encontro una salida por un posicion atras y por arriba
                                                        
                                                        matrizCaminos[moveFila][moveColumna-2]=1;
                                                        moveColumna--;
                                                        g.clearRect( initX, initY+10, 30, 30);
                                                        g.setColor(Color.BLACK);
                                                        g.drawRect(initX, initY, 50, 50);
                                                        initX-=50;
                                                        g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                                       
                                                        decisions=false;
                                                        marchaAtras=false;
                                                }
                                                else{
                                                    if (matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                            
                                                            matrizCaminos[moveFila][moveColumna-2]=1;
                                                            moveColumna--;
                                                            g.clearRect( initX, initY+10, 30, 30);
                                                            g.setColor(Color.BLACK);
                                                            g.drawRect(initX, initY, 50, 50);
                                                            initX-=50;
                                                            g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                                                    }
                                                    else{ 
                                                        decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                        
                                                    }
                                                    
                                                    }
                                                    try{
                                                        sleep(200);
                                                    }
                                                    catch(Exception ex){
                                                    
                                                    }
                                                }//fin del while marcha atras 
                                        
                                    }
                                    else{
                                        decisions=false;
                                        debeVolver=true;
                                    }
                                   
                                    
                                     
                                }
                                //pregunta el bloque de arriba que esta en el frente esta vacio y que si arriba de donde esta no ha pasado
                                else if (matrizOfWall[moveFila-1][moveColumna]==1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                                    matrizCaminos[moveFila-1][moveColumna-1]=1;
                                    moveFila--;
                                    g.clearRect( initX, initY+10, 30, 30);
                                    g.setColor(Color.BLACK);
                                    g.drawRect(initX, initY, 50, 50);
                                    initY-=50;
                                    g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                                    

                                }
                                else{
                                    //solamente si no ha pasado por arriba puede subir
                                    if (matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                                         moveFila--;
                                        g.clearRect( initX, initY+10, 30, 30);
                                        g.setColor(Color.BLACK);
                                        g.drawRect(initX, initY, 50, 50);
                                        initY-=50;
                                        g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                                        decisions=false;
                                    }
                                    
                                    //como aqui ya subio hay que buscar otras alternativas ya sea para atras o saber que entro en un callejon y debemos devolvernos por donde ya pasamos
                                    else{
                                        //pregunta si esta en la ultima posicion de la columna para que no vaya mas para atras
                                        if (moveColumna-1==0) {
                                            //esta metido en un callejon y ya llego a la primer columna por lo tanto devuelvase;
                                            decisions=false;
                                            debeVolver=true;
                                        }
                                        else if (matrizCaminos[moveFila][moveColumna-2]!=1) {
                                            //aquiiiiii
                                            if (moveFila==0) {
                                                if (matrizOfWall[moveFila-1][moveColumna-2]!=1&&matrizCaminos[moveFila-1][moveColumna-2]!=1) {
                                                    decisions=false;
                                                }
                                            }
                                            
                                            else{
                                                
                                                Boolean marchaAtras=true;
                                                while(marchaAtras){
                                                if (moveColumna-1==0) {
                                                       decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                }     
                                                else if (matrizOfWall[moveFila-1][moveColumna-2]!=1&&matrizCaminos[moveFila-1][moveColumna-2]!=1) {
                                                    decisions=false;
                                                    marchaAtras=false;
                                                }
                                                else{
                                                    if (matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                        matrizCaminos[moveFila][moveColumna-2]=1;
                                                        moveColumna--;
                                                        g.clearRect( initX, initY+10, 30, 30);
                                                        g.setColor(Color.BLACK);
                                                        g.drawRect(initX, initY, 50, 50);
                                                        initX-=50;
                                                        g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                                                    }
                                                    else{ 
                                                        decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                        
                                                    }
                                                    
                                                    }
                                                    try{
                                                        sleep(200);
                                                    }
                                                    catch(Exception ex){
                                                    
                                                    }
                                                } 
                                            }
                                                
                                            
                                           
                                        }
                                        else{
                                        
                                        }
                                        //
                                    }   
                                   
                                    
                                }
                            try{
                                sleep(500);
                            }catch(Exception ex){}
                            }
                        }//fin if de decisiones seria aqui un 1
                        else{
                            //vamos para abajo
                            while(decisions){
                                if (moveFila==topeFila-1 ) {
                                    if (matrizOfWall[moveFila][moveColumna-2]==1 && matrizOfWall[moveFila][moveColumna]==1) {
                                    }
                                    decisions=false;
                                }
                                else if (matrizOfWall[moveFila+1][moveColumna-1]==1&&matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                                    decisions=false;
                                } 
                                
                                else if(matrizOfWall[moveFila+1][moveColumna-1]==1&&matrizCaminos[moveFila-1][moveColumna-1]==1){
                                    //choco con un muro por el frente y por arriba, por el cual debe caminar hacia la izquierda para buscar una por arriba y sino devuelva por donde viene
                                    if (matrizCaminos[moveFila][moveColumna-2]!=1 &&matrizOfWall[moveFila][moveColumna-2]!=1) {
                                        
                                                Boolean marchaAtras=true;
                                                
                                                while(marchaAtras){
                                                    if (moveColumna-1==0) {
                                                       decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                }     
                                                    else if (matrizOfWall[moveFila+1][moveColumna-2]!=1&&matrizCaminos[moveFila+1][moveColumna-2]!=1 && matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                        //encontro una salida por un posicion atras y por arriba
                                                        
                                                        matrizCaminos[moveFila][moveColumna-2]=1;
                                                        moveColumna--;
                                                        g.clearRect( initX, initY+10, 30, 30);
                                                        g.setColor(Color.BLACK);
                                                        g.drawRect(initX, initY, 50, 50);
                                                        initX-=50;
                                                        g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                                       
                                                        decisions=false;
                                                        marchaAtras=false;
                                                }
                                                else{
                                                    if (matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                            
                                                            matrizCaminos[moveFila][moveColumna-2]=1;
                                                            moveColumna--;
                                                            g.clearRect( initX, initY+10, 30, 30);
                                                            g.setColor(Color.BLACK);
                                                            g.drawRect(initX, initY, 50, 50);
                                                            initX-=50;
                                                            g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                                                    }
                                                    else{ 
                                                        decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                        
                                                    }
                                                    
                                                    }
                                                    try{
                                                        sleep(200);
                                                    }
                                                    catch(Exception ex){
                                                    
                                                    }
                                                }//fin del while marcha atras 
                                        
                                    }
                                    else{
                                        decisions=false;
                                        debeVolver=true;
                                    }
                                   
                                    
                                     
                                }
                                else if (matrizOfWall[moveFila+1][moveColumna]==1) {
                                    matrizCaminos[moveFila+1][moveColumna-1]=1;
                                    moveFila++;
                                    g.clearRect( initX, initY+10, 30, 30);
                                    g.setColor(Color.BLACK);
                                    g.drawRect(initX, initY, 50, 50);
                                    initY+=50;
                                    g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                                    
                                }
                                else{
                                    if (matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                                        //va para abajo
                                        moveFila++;
                                        g.clearRect( initX, initY+10, 30, 30);
                                        g.setColor(Color.BLACK);
                                        g.drawRect(initX, initY, 50, 50);
                                        initY+=50;
                                        g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                                        decisions=false;
                                    }
                                    else{
                                        //solamente si no ha subido puede bajar
                                        if (matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                                             moveFila--;
                                            g.clearRect( initX, initY+10, 30, 30);
                                            g.setColor(Color.BLACK);
                                            g.drawRect(initX, initY, 50, 50);
                                            initY-=50;
                                            g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                                            decisions=false;
                                    }
                                        else{
                                            if (matrizCaminos[moveFila][moveColumna-2]!=1) {
                                                if (moveFila==0) {
                                                    if (matrizOfWall[moveFila+1][moveColumna-2]!=1 && matrizCaminos[moveFila+1][moveColumna-2]!=1) {
                                                        decisions=false;
                                                    }
                                                    else{
                                                        Boolean marchaAtras=true;
                                                        while(marchaAtras){
                                                        if (moveColumna-1==0) {
                                                               decisions=false;
                                                                marchaAtras=false;
                                                                debeVolver=true;
                                                        }     
                                                        else if (matrizOfWall[moveFila+1][moveColumna-2]!=1&&matrizCaminos[moveFila+1][moveColumna-2]!=1) {
                                                            decisions=false;
                                                            marchaAtras=false;
                                                        }
                                                        else{
                                                            if (matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                                    matrizCaminos[moveFila][moveColumna-2]=1;
                                                                    moveColumna++;
                                                                    g.clearRect( initX, initY+10, 30, 30);
                                                                    g.setColor(Color.BLACK);
                                                                    g.drawRect(initX, initY, 50, 50);
                                                                    initX+=50;
                                                                    g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                                                            }
                                                            else{ 
                                                                decisions=false;
                                                                marchaAtras=false;
                                                                debeVolver=true;

                                                            }

                                                            }
                                                            try{
                                                                sleep(200);
                                                            }
                                                            catch(Exception ex){

                                                            }
                                                        } 
                                                    
                                                    
                                                    
                                                    }
                                                    
                                                }
                                            else if ((matrizOfWall[moveFila-1][moveColumna-2]!=1&&matrizCaminos[moveFila-1][moveColumna-2]!=1) || (matrizOfWall[moveFila+1][moveColumna-2]!=1&&matrizCaminos[moveFila+1][moveColumna-2]!=1)) {
                                                //metase por ahi
                                                decisions=false;
                                            }
                                            else{
                                                
                                            matrizCaminos[moveFila][moveColumna-2]=1;
                                            moveColumna--;
                                            g.clearRect( initX, initY+10, 30, 30);
                                            g.setColor(Color.BLACK);
                                            g.drawRect(initX, initY, 50, 50);
                                            initX-=50;
                                            g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                                            }
//                                                JOptionPane.showMessageDialog(null, "El toque es que si tiene que aplicar reversa");
                                            }
                                        
                                        
                                        }
                                        //JOptionPane.showMessageDialog(null, "no puedo pasar donde ya pase");
                                    
                                    }
                                   
                                }
                            try{
                                sleep(500);
                            }catch(Exception ex){}
                            }
                    }
                    }
                    else{
                        int decision= (int)(Math.random()*2);
                        if (decision==0) {
                            if (matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                                matrizCaminos[moveFila-1][moveColumna-1]=1;
                                moveFila--;
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initY-=50;
                                g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                    }
                    }
                    else{
                        if (matrizOfWall[moveFila+1][moveColumna-1]!=1 && matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                            matrizCaminos[moveFila+1][moveColumna-1]=1;
                            moveFila++;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY+=50;
                            g.drawImage(bufferedPersonaje2, initX, initY+10, 30, 30, null);
                    }
                    }          
                    }
                }
                }
                try{
                    sleep(500);
                }catch(Exception ex){}
            }
        }
    }.start();
}   
    
    public void runImage3 (Graphics g, BufferedImage bufferedPersonaje3, int [][] matrizOfWall, int typeSpeed,
            JLabel lb_win1, JLabel lb_win2, JLabel lb_win3, JLabel lb_win4, JComboBox combo){
        
        new Thread(){
        public void run(){
     
            if (combo.getSelectedIndex()==0) {
                matrizCaminos=new int[10][10];
                moveFila=7;
                initX=250;
                initY=500;
                topeFila = 10;
                topeColumna = 10 ;
            }
            else if (combo.getSelectedIndex()==1) {
                matrizCaminos=new int[10][14];
                moveFila=7;
                initX=250;
                initY=500;
                topeFila = 10;
                topeColumna = 14;
            }
            else if (combo.getSelectedIndex()==2) {
                matrizCaminos= new int[11][18];
                moveFila=7;
                initX=150;
                initY=500;
                topeFila = 11;
                topeColumna = 18;
            }
            
            int second = 0;
            int speed = 800;
            
            int moveAux=moveFila;
            Boolean callejonRecto=false;
            Boolean callejonReversa=false;
            Boolean callejonSubiendo=false;
            Boolean callejonBajando=false;
            Boolean decisions=false;
            Boolean debeVolver=false;
            boolean primerIngreso=true;
            boolean exitvalidation = true;
            while(exitvalidation){
                
                if (typeSpeed==1) {
                    
                    try{
                        Thread.sleep(500);    
                        second++;  
                        if (second>=0 && second<=10) {
                            speed=-900;
                        
                        }if (second>=10 && second<=15) {
                            Thread.sleep(999);
                            speed=800;
                            if (second>=15){
                                second=0;
                            }
                        }
                        

                    }catch(Exception e){}
                }
                
                if (typeSpeed==2) {
                    speed=1200;
                }
                if (matrizOfWall[moveFila][moveColumna]==8) {
                    exitvalidation=false;
                    if (lb_win1.getText().equals("")) {
                        lb_win1.setText("List of Winners : 1) Blue Bug");
                    }else if (lb_win2.getText().equals("")) {
                        lb_win2.setText("2) Blue Bug");
                    }else if (lb_win3.getText().equals("")) {
                        lb_win3.setText("3) Blue Bug");
                    }else if (lb_win4.getText().equals("")) {
                        lb_win4.setText("4) Blue Bug");
                    }
                }               
                //para devolverse en el callejon 
                if(debeVolver==true){
                    matrizCaminos= new int[10][10];
                    debeVolver=false;
                }else{     
                //cuando se mete por primera ves 
                if (primerIngreso) {
                    if(matrizOfWall[moveFila][moveColumna]!=1 && initX<300 && matrizCaminos[moveFila][moveColumna]!=1){
                    
                        g.clearRect( initX, initY+10, 30, 30);
                        initX+=50;
                        g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                        matrizCaminos[moveFila][moveColumna]=1;
                        moveColumna++;
                        primerIngreso=false;
                        }// fin del if 
                 }else if (moveFila==0) {
                    if (moveColumna==topeColumna) {
                        if (matrizOfWall[moveFila+1][moveColumna-1]!=1 && matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                                matrizCaminos[moveFila+1][moveColumna-1]=1;
                                moveFila++;
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initY+=50;
                                g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                        }else if (matrizOfWall[moveFila][moveColumna-2]!=1 && matrizCaminos[moveFila][moveColumna-2]!=1) {
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX-=50;
                                g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna-2]=1;
                               moveColumna--;
                        }else {
                            debeVolver=true;}
                    }

                    else if (matrizCaminos[moveFila][moveColumna]!=1 || matrizCaminos[moveFila][moveColumna-2]!=1 || matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                        //pregunta si al frente hay muro o si no ha pasado
                        if (matrizOfWall[moveFila][moveColumna]!=1 && matrizCaminos[moveFila][moveColumna]!=1) {
                                //para adelante
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX+=50;
                                g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna]=1;
                                moveColumna++;
                        }
                        else if (matrizOfWall[moveFila][moveColumna-2]!=1 && matrizCaminos[moveFila][moveColumna-2]!=1) {
                                //va para atras
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX-=50;
                                g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna-2]=1;
                               moveColumna--;
                        }
                        else if (matrizOfWall[moveFila+1][moveColumna-1]!=1 && matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                                //va para abajo
                                matrizCaminos[moveFila+1][moveColumna-1]=1;
                                moveFila++;
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initY+=50;
                                g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                               
                            

                        }
                        else{
                        debeVolver=true;
                       
                        }
                        
                        
                        
                        
                    }
    
                    
                }
                else if (moveFila==topeFila-1) {
                    
                     if (moveColumna==topeColumna-1) {
                           if (matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                                matrizCaminos[moveFila-1][moveColumna-1]=1;
                                moveFila--;
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initY-=50;
                                g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                        }
                        else if (matrizOfWall[moveFila][moveColumna-2]!=1 && matrizCaminos[moveFila][moveColumna-2]!=1) {
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX-=50;
                                g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna-2]=1;
                               moveColumna--;
                        }
                        else{
                            debeVolver=true;
                        }
                    }
                    else if (matrizCaminos[moveFila][moveColumna]!=1 || matrizCaminos[moveFila][moveColumna-2]!=1 || matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                        
                        if (matrizOfWall[moveFila][moveColumna]!=1 && matrizCaminos[moveFila][moveColumna]!=1) {
                                //para adelante
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX+=50;
                                g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna]=1;
                                
                                moveColumna++;
                                
                        }
                        else if (matrizOfWall[moveFila][moveColumna-2]!=1 && matrizCaminos[moveFila][moveColumna-2]!=1) {
                                //va para atras
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX-=50;
                                g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                                callejonRecto=true;
                                matrizCaminos[moveFila][moveColumna-2]=1;
                               moveColumna--;
                        }
                        else if (matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                            //va para arriba
                            matrizCaminos[moveFila-1][moveColumna-1]=1;
                            moveFila--;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY-=50;
                            g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);

                        }else{
                              debeVolver=true;
                              
                        }
                          
                          
                          
                          
                    }  
                }
                else if (moveColumna==0) {
                      if (matrizCaminos[moveFila][moveColumna]!=1 || matrizCaminos[moveFila-1][moveColumna-1]!=1 || matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                        
                        if (matrizOfWall[moveFila][moveColumna]!=1 && matrizCaminos[moveFila][moveColumna]!=1) {
                                //para adelante
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX+=50;
                                g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna]=1;
                                moveColumna++;   
                        }
                        else if (matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                            //va para arriba
                            matrizCaminos[moveFila-1][moveColumna-1]=1;
                            moveFila--;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY-=50;
                            g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);

                        }
                        else if (matrizOfWall[moveFila+1][moveColumna-1]!=1 && matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                            //va para abajo
                            matrizCaminos[moveFila+1][moveColumna-1]=1;
                            moveFila++;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY+=50;
                            g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                        }
                        else{
                            debeVolver=true;
                            
                        }
                          
                        
                      }
                    
                    }
                else if (moveColumna==topeColumna) {
                      if (matrizCaminos[moveFila][moveColumna-2]!=1 || matrizCaminos[moveFila-1][moveColumna-1]!=1 || matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                        
                          if (matrizOfWall[moveFila][moveColumna-2]!=1 && matrizCaminos[moveFila][moveColumna-2]!=1) {
                                //va para atras
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX-=50;
                                g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna-2]=1;
                                moveColumna--;
                        }
                        else if (matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                            //va para arriba
                            matrizCaminos[moveFila-1][moveColumna-1]=1;
                            moveFila--;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY-=50;
                            g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);

                        }
                        else if (matrizOfWall[moveFila+1][moveColumna-1]!=1 && matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                            //va para abajo
                            moveFila++;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY+=50;
                            g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                            
                        }
                        else{
                            debeVolver=true;
                            
                        
                        }
                          
                          
                          
                          
                    }  
                    }
                //avanzando en linea recta
                else if (matrizOfWall[moveFila][moveColumna]!=1 && matrizCaminos[moveFila][moveColumna]!=1 && matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                     int decision= (int)(Math.random()*2);
                     if (decision==0) {
                        //quiso irse por arriba
                                matrizCaminos[moveFila-1][moveColumna-1]=1;
                                moveFila--;
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initY-=50;
                                g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                    }
                     else{
                         //quiso irse por linea recta
                         g.clearRect( initX, initY+10, 30, 30);
                        g.setColor(Color.BLACK);
                        g.drawRect(initX, initY, 50, 50);
                        initX+=50;
                        g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                        matrizCaminos[moveFila][moveColumna]=1;
                        moveColumna++;
                     }
   
                    }
                else if(matrizOfWall[moveFila][moveColumna]!=1 && matrizCaminos[moveFila][moveColumna]!=1){
                    g.clearRect( initX, initY+10, 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(initX, initY, 50, 50);
                    initX+=50;
                    g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                    matrizCaminos[moveFila][moveColumna]=1;
                    moveColumna++;
                }
                //cuando avanzando en linea recta encontro un callejonRecto
                else if (matrizOfWall[moveFila][moveColumna]==1 && matrizOfWall[moveFila-1][moveColumna-1]==1 && matrizOfWall[moveFila+1][moveColumna-1]==1) {
                    //va para atras
                    g.clearRect( initX, initY+10, 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(initX, initY, 50, 50);
                    initX-=50;
                    g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                    callejonRecto=true;
                    matrizCaminos[moveFila][moveColumna-2]=1;
                   moveColumna--;
                }
                //cuando debera buscar otro camino porque no es un callejon y encontro un muro
                else{
                        //este para que el vaya subiendo recto hasta que encuentre una salida(sube y sube )
                    if (matrizOfWall[moveFila-1][moveColumna]==1||matrizOfWall[moveFila+1][moveColumna]==1) {
                        decisions=true;

                        int decision= (int)(Math.random()*2);
                        if (decision==0) {
                            //vamos para arriba
                            while(decisions){
                                if (moveFila==0) {
                                    if (matrizOfWall[moveFila][moveColumna-2]==1 && matrizOfWall[moveFila][moveColumna]==1) {
                                       
                                    }
                                    decisions=false;
                                }
                                else if (matrizOfWall[moveFila-1][moveColumna-1]==1&&matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                                    decisions=false;
                                }  
                                
                                else if(matrizOfWall[moveFila-1][moveColumna-1]==1 && matrizCaminos[moveFila+1][moveColumna-1]==1){
                                    //choco con un muro por el frente y por arriba, por el cual debe caminar hacia la izquierda para buscar una por arriba y sino devuelva por donde viene
                                    if (matrizCaminos[moveFila][moveColumna-2]!=1 && matrizOfWall[moveFila][moveColumna-2]!=1) {
                                        
                                                Boolean marchaAtras=true;
                                                
                                                while(marchaAtras){
                                                    if (moveColumna-1==0) {
                                                       decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                }     
                                                    else if (matrizOfWall[moveFila-1][moveColumna-2]!=1&&matrizCaminos[moveFila-1][moveColumna-2]!=1 && matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                        //encontro una salida por un posicion atras y por arriba
                                                        
                                                        matrizCaminos[moveFila][moveColumna-2]=1;
                                                        moveColumna--;
                                                        g.clearRect( initX, initY+10, 30, 30);
                                                        g.setColor(Color.BLACK);
                                                        g.drawRect(initX, initY, 50, 50);
                                                        initX-=50;
                                                        g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                                       
                                                        decisions=false;
                                                        marchaAtras=false;
                                                }
                                                else{
                                                    if (matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                            
                                                            matrizCaminos[moveFila][moveColumna-2]=1;
                                                            moveColumna--;
                                                            g.clearRect( initX, initY+10, 30, 30);
                                                            g.setColor(Color.BLACK);
                                                            g.drawRect(initX, initY, 50, 50);
                                                            initX-=50;
                                                            g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                                                    }
                                                    else{ 
                                                        decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                        
                                                    }
                                                    
                                                    }
                                                    try{
                                                        sleep(200);
                                                    }
                                                    catch(Exception ex){
                                                    
                                                    }
                                                }//fin del while marcha atras 
                                        
                                    }
                                    else{
                                        decisions=false;
                                        debeVolver=true;
                                    }
                                   
                                    
                                     
                                }
                                //pregunta el bloque de arriba que esta en el frente esta vacio y que si arriba de donde esta no ha pasado
                                else if (matrizOfWall[moveFila-1][moveColumna]==1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                                    matrizCaminos[moveFila-1][moveColumna-1]=1;
                                    moveFila--;
                                    g.clearRect( initX, initY+10, 30, 30);
                                    g.setColor(Color.BLACK);
                                    g.drawRect(initX, initY, 50, 50);
                                    initY-=50;
                                    g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                                    

                                }
                                else{
                                    //solamente si no ha pasado por arriba puede subir
                                    if (matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                                         moveFila--;
                                        g.clearRect( initX, initY+10, 30, 30);
                                        g.setColor(Color.BLACK);
                                        g.drawRect(initX, initY, 50, 50);
                                        initY-=50;
                                        g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                                        decisions=false;
                                    }
                                    
                                    //como aqui ya subio hay que buscar otras alternativas ya sea para atras o saber que entro en un callejon y debemos devolvernos por donde ya pasamos
                                    else{
                                        //pregunta si esta en la ultima posicion de la columna para que no vaya mas para atras
                                        if (moveColumna-1==0) {
                                            //esta metido en un callejon y ya llego a la primer columna por lo tanto devuelvase;
                                            decisions=false;
                                            debeVolver=true;
                                        }
                                        else if (matrizCaminos[moveFila][moveColumna-2]!=1) {
                                            //aquiiiiii
                                            if (moveFila==0) {
                                                if (matrizOfWall[moveFila-1][moveColumna-2]!=1&&matrizCaminos[moveFila-1][moveColumna-2]!=1) {
                                                    decisions=false;
                                                }
                                            }
                                            
                                            else{
                                                
                                                Boolean marchaAtras=true;
                                                while(marchaAtras){
                                                if (moveColumna-1==0) {
                                                       decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                }     
                                                else if (matrizOfWall[moveFila-1][moveColumna-2]!=1&&matrizCaminos[moveFila-1][moveColumna-2]!=1) {
                                                    decisions=false;
                                                    marchaAtras=false;
                                                }
                                                else{
                                                    if (matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                        matrizCaminos[moveFila][moveColumna-2]=1;
                                                        moveColumna--;
                                                        g.clearRect( initX, initY+10, 30, 30);
                                                        g.setColor(Color.BLACK);
                                                        g.drawRect(initX, initY, 50, 50);
                                                        initX-=50;
                                                        g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                                                    }
                                                    else{ 
                                                        decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                        
                                                    }
                                                    
                                                    }
                                                    try{
                                                        sleep(200);
                                                    }
                                                    catch(Exception ex){
                                                    
                                                    }
                                                } 
                                            }
                                                
                                            
                                           
                                        }
                                        else{
                                        
                                        }
                                        //
                                    }   
                                   
                                    
                                }
                            try{
                                sleep(500);
                            }catch(Exception ex){}
                            }
                        }//fin if de decisiones seria aqui un 1
                        else{
                            //vamos para abajo
                            while(decisions){
                                if (moveFila==topeFila-1 ) {
                                    if (matrizOfWall[moveFila][moveColumna-2]==1 && matrizOfWall[moveFila][moveColumna]==1) {
                                    }
                                    decisions=false;
                                }
                                else if (matrizOfWall[moveFila+1][moveColumna-1]==1&&matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                                    decisions=false;
                                } 
                                
                                else if(matrizOfWall[moveFila+1][moveColumna-1]==1&&matrizCaminos[moveFila-1][moveColumna-1]==1){
                                    //choco con un muro por el frente y por arriba, por el cual debe caminar hacia la izquierda para buscar una por arriba y sino devuelva por donde viene
                                    if (matrizCaminos[moveFila][moveColumna-2]!=1 &&matrizOfWall[moveFila][moveColumna-2]!=1) {
                                        
                                                Boolean marchaAtras=true;
                                                
                                                while(marchaAtras){
                                                    if (moveColumna-1==0) {
                                                       decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                }     
                                                    else if (matrizOfWall[moveFila+1][moveColumna-2]!=1&&matrizCaminos[moveFila+1][moveColumna-2]!=1 && matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                        //encontro una salida por un posicion atras y por arriba
                                                        
                                                        matrizCaminos[moveFila][moveColumna-2]=1;
                                                        moveColumna--;
                                                        g.clearRect( initX, initY+10, 30, 30);
                                                        g.setColor(Color.BLACK);
                                                        g.drawRect(initX, initY, 50, 50);
                                                        initX-=50;
                                                        g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                                       
                                                        decisions=false;
                                                        marchaAtras=false;
                                                }
                                                else{
                                                    if (matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                            
                                                            matrizCaminos[moveFila][moveColumna-2]=1;
                                                            moveColumna--;
                                                            g.clearRect( initX, initY+10, 30, 30);
                                                            g.setColor(Color.BLACK);
                                                            g.drawRect(initX, initY, 50, 50);
                                                            initX-=50;
                                                            g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                                                    }
                                                    else{ 
                                                        decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                        
                                                    }
                                                    
                                                    }
                                                    try{
                                                        sleep(200);
                                                    }
                                                    catch(Exception ex){
                                                    
                                                    }
                                                }//fin del while marcha atras 
                                        
                                    }
                                    else{
                                        decisions=false;
                                        debeVolver=true;
                                    }
                                   
                                    
                                     
                                }
                                else if (matrizOfWall[moveFila+1][moveColumna]==1) {
                                    matrizCaminos[moveFila+1][moveColumna-1]=1;
                                    moveFila++;
                                    g.clearRect( initX, initY+10, 30, 30);
                                    g.setColor(Color.BLACK);
                                    g.drawRect(initX, initY, 50, 50);
                                    initY+=50;
                                    g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                                    
                                }
                                else{
                                    if (matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                                        //va para abajo
                                        moveFila++;
                                        g.clearRect( initX, initY+10, 30, 30);
                                        g.setColor(Color.BLACK);
                                        g.drawRect(initX, initY, 50, 50);
                                        initY+=50;
                                        g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                                        decisions=false;
                                    }
                                    else{
                                        //solamente si no ha subido puede bajar
                                        if (matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                                             moveFila--;
                                            g.clearRect( initX, initY+10, 30, 30);
                                            g.setColor(Color.BLACK);
                                            g.drawRect(initX, initY, 50, 50);
                                            initY-=50;
                                            g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                                            decisions=false;
                                    }
                                        else{
                                            if (matrizCaminos[moveFila][moveColumna-2]!=1) {
                                                if (moveFila==0) {
                                                    if (matrizOfWall[moveFila+1][moveColumna-2]!=1 && matrizCaminos[moveFila+1][moveColumna-2]!=1) {
                                                        decisions=false;
                                                    }
                                                    else{
                                                        Boolean marchaAtras=true;
                                                        while(marchaAtras){
                                                        if (moveColumna-1==0) {
                                                               decisions=false;
                                                                marchaAtras=false;
                                                                debeVolver=true;
                                                        }     
                                                        else if (matrizOfWall[moveFila+1][moveColumna-2]!=1&&matrizCaminos[moveFila+1][moveColumna-2]!=1) {
                                                            decisions=false;
                                                            marchaAtras=false;
                                                        }
                                                        else{
                                                            if (matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                                    matrizCaminos[moveFila][moveColumna-2]=1;
                                                                    moveColumna++;
                                                                    g.clearRect( initX, initY+10, 30, 30);
                                                                    g.setColor(Color.BLACK);
                                                                    g.drawRect(initX, initY, 50, 50);
                                                                    initX+=50;
                                                                    g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                                                            }
                                                            else{ 
                                                                decisions=false;
                                                                marchaAtras=false;
                                                                debeVolver=true;

                                                            }

                                                            }
                                                            try{
                                                                sleep(200);
                                                            }
                                                            catch(Exception ex){

                                                            }
                                                        } 
                                                    
                                                    
                                                    
                                                    }
                                                    
                                                }
                                            else if ((matrizOfWall[moveFila-1][moveColumna-2]!=1&&matrizCaminos[moveFila-1][moveColumna-2]!=1) || (matrizOfWall[moveFila+1][moveColumna-2]!=1&&matrizCaminos[moveFila+1][moveColumna-2]!=1)) {
                                                //metase por ahi
                                                decisions=false;
                                            }
                                            else{
                                                
                                            matrizCaminos[moveFila][moveColumna-2]=1;
                                            moveColumna--;
                                            g.clearRect( initX, initY+10, 30, 30);
                                            g.setColor(Color.BLACK);
                                            g.drawRect(initX, initY, 50, 50);
                                            initX-=50;
                                            g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                                            }
//                                                JOptionPane.showMessageDialog(null, "El toque es que si tiene que aplicar reversa");
                                            }
                                        
                                        
                                        }
                                        //JOptionPane.showMessageDialog(null, "no puedo pasar donde ya pase");
                                    
                                    }
                                   
                                }
                            try{
                                sleep(500);
                            }catch(Exception ex){}
                            }
                    }
                    }
                    else{
                        int decision= (int)(Math.random()*2);
                        if (decision==0) {
                            if (matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                                matrizCaminos[moveFila-1][moveColumna-1]=1;
                                moveFila--;
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initY-=50;
                                g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                    }
                    }
                    else{
                        if (matrizOfWall[moveFila+1][moveColumna-1]!=1 && matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                            matrizCaminos[moveFila+1][moveColumna-1]=1;
                            moveFila++;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY+=50;
                            g.drawImage(bufferedPersonaje3, initX, initY+10, 30, 30, null);
                    }
                    }          
                    }
                }
                }
                try{
                    sleep(500);
                }catch(Exception ex){}
            }
        }
    }.start();
}   
    
      
    public void runImage4 (Graphics g, BufferedImage bufferedPersonaje4, int [][] matrizOfWall, int typeSpeed,
            JLabel lb_win1, JLabel lb_win2, JLabel lb_win3, JLabel lb_win4, JComboBox combo){
        
        new Thread(){
        public void run(){
     
            if (combo.getSelectedIndex()==0) {
                matrizCaminos=new int[10][10];
                moveFila=7;
                initX=250;
                initY=500;
                topeFila = 10;
                topeColumna = 10 ;
            }
            else if (combo.getSelectedIndex()==1) {
                matrizCaminos=new int[10][14];
                moveFila=7;
                initX=250;
                initY=500;
                topeFila = 10;
                topeColumna = 14;
            }
            else if (combo.getSelectedIndex()==2) {
                matrizCaminos= new int[11][18];
                moveFila=7;
                initX=150;
                initY=500;
                topeFila = 11;
                topeColumna = 18;
            }
            
            int second = 0;
            int speed = 800;
            
            int moveAux=moveFila;
            Boolean callejonRecto=false;
            Boolean callejonReversa=false;
            Boolean callejonSubiendo=false;
            Boolean callejonBajando=false;
            Boolean decisions=false;
            Boolean debeVolver=false;
            boolean primerIngreso=true;
            boolean exitvalidation = true;
            while(exitvalidation){
                
                if (typeSpeed==1) {
                    
                    try{
                        Thread.sleep(500);    
                        second++;  
                        if (second>=0 && second<=10) {
                            speed=-900;
                        
                        }if (second>=10 && second<=15) {
                            Thread.sleep(999);
                            speed=800;
                            if (second>=15){
                                second=0;
                            }
                        }
                        

                    }catch(Exception e){}
                }
                
                if (typeSpeed==2) {
                    speed=1200;
                }
                if (matrizOfWall[moveFila][moveColumna]==8) {
                    exitvalidation=false;
                    if (lb_win1.getText().equals("")) {
                        lb_win1.setText("List of Winners : 1) Yellow Bug");
                    }else if (lb_win2.getText().equals("")) {
                        lb_win2.setText("2) Yellow Bug");
                    }else if (lb_win3.getText().equals("")) {
                        lb_win3.setText("3) Yellow Bug");
                    }else if (lb_win4.getText().equals("")) {
                        lb_win4.setText("4) Yellow Bug");
                    }
                }               
                //para devolverse en el callejon 
                if(debeVolver==true){
                    matrizCaminos= new int[10][10];
                    debeVolver=false;
                }else{     
                //cuando se mete por primera ves 
                if (primerIngreso) {
                    if(matrizOfWall[moveFila][moveColumna]!=1 && initX<300 && matrizCaminos[moveFila][moveColumna]!=1){
                    
                        g.clearRect( initX, initY+10, 30, 30);
                        initX+=50;
                        g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                        matrizCaminos[moveFila][moveColumna]=1;
                        moveColumna++;
                        primerIngreso=false;
                        }// fin del if 
                 }else if (moveFila==0) {
                    if (moveColumna==topeColumna) {
                        if (matrizOfWall[moveFila+1][moveColumna-1]!=1 && matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                                matrizCaminos[moveFila+1][moveColumna-1]=1;
                                moveFila++;
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initY+=50;
                                g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                        }else if (matrizOfWall[moveFila][moveColumna-2]!=1 && matrizCaminos[moveFila][moveColumna-2]!=1) {
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX-=50;
                                g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna-2]=1;
                               moveColumna--;
                        }else {
                            debeVolver=true;}
                    }

                    else if (matrizCaminos[moveFila][moveColumna]!=1 || matrizCaminos[moveFila][moveColumna-2]!=1 || matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                        //pregunta si al frente hay muro o si no ha pasado
                        if (matrizOfWall[moveFila][moveColumna]!=1 && matrizCaminos[moveFila][moveColumna]!=1) {
                                //para adelante
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX+=50;
                                g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna]=1;
                                moveColumna++;
                        }
                        else if (matrizOfWall[moveFila][moveColumna-2]!=1 && matrizCaminos[moveFila][moveColumna-2]!=1) {
                                //va para atras
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX-=50;
                                g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna-2]=1;
                               moveColumna--;
                        }
                        else if (matrizOfWall[moveFila+1][moveColumna-1]!=1 && matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                                //va para abajo
                                matrizCaminos[moveFila+1][moveColumna-1]=1;
                                moveFila++;
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initY+=50;
                                g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                               
                            

                        }
                        else{
                        debeVolver=true;
                       
                        }
                        
                        
                        
                        
                    }
    
                    
                }
                else if (moveFila==topeFila-1) {
                    
                     if (moveColumna==topeColumna-1) {
                           if (matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                                matrizCaminos[moveFila-1][moveColumna-1]=1;
                                moveFila--;
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initY-=50;
                                g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                        }
                        else if (matrizOfWall[moveFila][moveColumna-2]!=1 && matrizCaminos[moveFila][moveColumna-2]!=1) {
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX-=50;
                                g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna-2]=1;
                               moveColumna--;
                        }
                        else{
                            debeVolver=true;
                        }
                    }
                    else if (matrizCaminos[moveFila][moveColumna]!=1 || matrizCaminos[moveFila][moveColumna-2]!=1 || matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                        
                        if (matrizOfWall[moveFila][moveColumna]!=1 && matrizCaminos[moveFila][moveColumna]!=1) {
                                //para adelante
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX+=50;
                                g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna]=1;
                                
                                moveColumna++;
                                
                        }
                        else if (matrizOfWall[moveFila][moveColumna-2]!=1 && matrizCaminos[moveFila][moveColumna-2]!=1) {
                                //va para atras
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX-=50;
                                g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                                callejonRecto=true;
                                matrizCaminos[moveFila][moveColumna-2]=1;
                               moveColumna--;
                        }
                        else if (matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                            //va para arriba
                            matrizCaminos[moveFila-1][moveColumna-1]=1;
                            moveFila--;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY-=50;
                            g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);

                        }else{
                              debeVolver=true;
                              
                        }
                          
                          
                          
                          
                    }  
                }
                else if (moveColumna==0) {
                      if (matrizCaminos[moveFila][moveColumna]!=1 || matrizCaminos[moveFila-1][moveColumna-1]!=1 || matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                        
                        if (matrizOfWall[moveFila][moveColumna]!=1 && matrizCaminos[moveFila][moveColumna]!=1) {
                                //para adelante
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX+=50;
                                g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna]=1;
                                moveColumna++;   
                        }
                        else if (matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                            //va para arriba
                            matrizCaminos[moveFila-1][moveColumna-1]=1;
                            moveFila--;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY-=50;
                            g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);

                        }
                        else if (matrizOfWall[moveFila+1][moveColumna-1]!=1 && matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                            //va para abajo
                            matrizCaminos[moveFila+1][moveColumna-1]=1;
                            moveFila++;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY+=50;
                            g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                        }
                        else{
                            debeVolver=true;
                            
                        }
                          
                        
                      }
                    
                    }
                else if (moveColumna==topeColumna) {
                      if (matrizCaminos[moveFila][moveColumna-2]!=1 || matrizCaminos[moveFila-1][moveColumna-1]!=1 || matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                        
                          if (matrizOfWall[moveFila][moveColumna-2]!=1 && matrizCaminos[moveFila][moveColumna-2]!=1) {
                                //va para atras
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initX-=50;
                                g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                                matrizCaminos[moveFila][moveColumna-2]=1;
                                moveColumna--;
                        }
                        else if (matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                            //va para arriba
                            matrizCaminos[moveFila-1][moveColumna-1]=1;
                            moveFila--;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY-=50;
                            g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);

                        }
                        else if (matrizOfWall[moveFila+1][moveColumna-1]!=1 && matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                            //va para abajo
                            moveFila++;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY+=50;
                            g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                            
                        }
                        else{
                            debeVolver=true;
                            
                        
                        }
                          
                          
                          
                          
                    }  
                    }
                //avanzando en linea recta
                else if (matrizOfWall[moveFila][moveColumna]!=1 && matrizCaminos[moveFila][moveColumna]!=1 && matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                     int decision= (int)(Math.random()*2);
                     if (decision==0) {
                        //quiso irse por arriba
                                matrizCaminos[moveFila-1][moveColumna-1]=1;
                                moveFila--;
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initY-=50;
                                g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                    }
                     else{
                         //quiso irse por linea recta
                         g.clearRect( initX, initY+10, 30, 30);
                        g.setColor(Color.BLACK);
                        g.drawRect(initX, initY, 50, 50);
                        initX+=50;
                        g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                        matrizCaminos[moveFila][moveColumna]=1;
                        moveColumna++;
                     }
   
                    }
                else if(matrizOfWall[moveFila][moveColumna]!=1 && matrizCaminos[moveFila][moveColumna]!=1){
                    g.clearRect( initX, initY+10, 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(initX, initY, 50, 50);
                    initX+=50;
                    g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                    matrizCaminos[moveFila][moveColumna]=1;
                    moveColumna++;
                }
                //cuando avanzando en linea recta encontro un callejonRecto
                else if (matrizOfWall[moveFila][moveColumna]==1 && matrizOfWall[moveFila-1][moveColumna-1]==1 && matrizOfWall[moveFila+1][moveColumna-1]==1) {
                    //va para atras
                    g.clearRect( initX, initY+10, 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(initX, initY, 50, 50);
                    initX-=50;
                    g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                    callejonRecto=true;
                    matrizCaminos[moveFila][moveColumna-2]=1;
                   moveColumna--;
                }
                //cuando debera buscar otro camino porque no es un callejon y encontro un muro
                else{
                        //este para que el vaya subiendo recto hasta que encuentre una salida(sube y sube )
                    if (matrizOfWall[moveFila-1][moveColumna]==1||matrizOfWall[moveFila+1][moveColumna]==1) {
                        decisions=true;

                        int decision= (int)(Math.random()*2);
                        if (decision==0) {
                            //vamos para arriba
                            while(decisions){
                                if (moveFila==0) {
                                    if (matrizOfWall[moveFila][moveColumna-2]==1 && matrizOfWall[moveFila][moveColumna]==1) {
                                       
                                    }
                                    decisions=false;
                                }
                                else if (matrizOfWall[moveFila-1][moveColumna-1]==1&&matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                                    decisions=false;
                                }  
                                
                                else if(matrizOfWall[moveFila-1][moveColumna-1]==1 && matrizCaminos[moveFila+1][moveColumna-1]==1){
                                    //choco con un muro por el frente y por arriba, por el cual debe caminar hacia la izquierda para buscar una por arriba y sino devuelva por donde viene
                                    if (matrizCaminos[moveFila][moveColumna-2]!=1 && matrizOfWall[moveFila][moveColumna-2]!=1) {
                                        
                                                Boolean marchaAtras=true;
                                                
                                                while(marchaAtras){
                                                    if (moveColumna-1==0) {
                                                       decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                }     
                                                    else if (matrizOfWall[moveFila-1][moveColumna-2]!=1&&matrizCaminos[moveFila-1][moveColumna-2]!=1 && matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                        //encontro una salida por un posicion atras y por arriba
                                                        
                                                        matrizCaminos[moveFila][moveColumna-2]=1;
                                                        moveColumna--;
                                                        g.clearRect( initX, initY+10, 30, 30);
                                                        g.setColor(Color.BLACK);
                                                        g.drawRect(initX, initY, 50, 50);
                                                        initX-=50;
                                                        g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                                       
                                                        decisions=false;
                                                        marchaAtras=false;
                                                }
                                                else{
                                                    if (matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                            
                                                            matrizCaminos[moveFila][moveColumna-2]=1;
                                                            moveColumna--;
                                                            g.clearRect( initX, initY+10, 30, 30);
                                                            g.setColor(Color.BLACK);
                                                            g.drawRect(initX, initY, 50, 50);
                                                            initX-=50;
                                                            g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                                                    }
                                                    else{ 
                                                        decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                        
                                                    }
                                                    
                                                    }
                                                    try{
                                                        sleep(200);
                                                    }
                                                    catch(Exception ex){
                                                    
                                                    }
                                                }//fin del while marcha atras 
                                        
                                    }
                                    else{
                                        decisions=false;
                                        debeVolver=true;
                                    }
                                   
                                    
                                     
                                }
                                //pregunta el bloque de arriba que esta en el frente esta vacio y que si arriba de donde esta no ha pasado
                                else if (matrizOfWall[moveFila-1][moveColumna]==1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                                    matrizCaminos[moveFila-1][moveColumna-1]=1;
                                    moveFila--;
                                    g.clearRect( initX, initY+10, 30, 30);
                                    g.setColor(Color.BLACK);
                                    g.drawRect(initX, initY, 50, 50);
                                    initY-=50;
                                    g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                                    

                                }
                                else{
                                    //solamente si no ha pasado por arriba puede subir
                                    if (matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                                         moveFila--;
                                        g.clearRect( initX, initY+10, 30, 30);
                                        g.setColor(Color.BLACK);
                                        g.drawRect(initX, initY, 50, 50);
                                        initY-=50;
                                        g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                                        decisions=false;
                                    }
                                    
                                    //como aqui ya subio hay que buscar otras alternativas ya sea para atras o saber que entro en un callejon y debemos devolvernos por donde ya pasamos
                                    else{
                                        //pregunta si esta en la ultima posicion de la columna para que no vaya mas para atras
                                        if (moveColumna-1==0) {
                                            //esta metido en un callejon y ya llego a la primer columna por lo tanto devuelvase;
                                            decisions=false;
                                            debeVolver=true;
                                        }
                                        else if (matrizCaminos[moveFila][moveColumna-2]!=1) {
                                            //aquiiiiii
                                            if (moveFila==0) {
                                                if (matrizOfWall[moveFila-1][moveColumna-2]!=1&&matrizCaminos[moveFila-1][moveColumna-2]!=1) {
                                                    decisions=false;
                                                }
                                            }
                                            
                                            else{
                                                
                                                Boolean marchaAtras=true;
                                                while(marchaAtras){
                                                if (moveColumna-1==0) {
                                                       decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                }     
                                                else if (matrizOfWall[moveFila-1][moveColumna-2]!=1&&matrizCaminos[moveFila-1][moveColumna-2]!=1) {
                                                    decisions=false;
                                                    marchaAtras=false;
                                                }
                                                else{
                                                    if (matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                        matrizCaminos[moveFila][moveColumna-2]=1;
                                                        moveColumna--;
                                                        g.clearRect( initX, initY+10, 30, 30);
                                                        g.setColor(Color.BLACK);
                                                        g.drawRect(initX, initY, 50, 50);
                                                        initX-=50;
                                                        g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                                                    }
                                                    else{ 
                                                        decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                        
                                                    }
                                                    
                                                    }
                                                    try{
                                                        sleep(200);
                                                    }
                                                    catch(Exception ex){
                                                    
                                                    }
                                                } 
                                            }
                                                
                                            
                                           
                                        }
                                        else{
                                        
                                        }
                                        //
                                    }   
                                   
                                    
                                }
                            try{
                                sleep(500);
                            }catch(Exception ex){}
                            }
                        }//fin if de decisiones seria aqui un 1
                        else{
                            //vamos para abajo
                            while(decisions){
                                if (moveFila==topeFila-1 ) {
                                    if (matrizOfWall[moveFila][moveColumna-2]==1 && matrizOfWall[moveFila][moveColumna]==1) {
                                    }
                                    decisions=false;
                                }
                                else if (matrizOfWall[moveFila+1][moveColumna-1]==1&&matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                                    decisions=false;
                                } 
                                
                                else if(matrizOfWall[moveFila+1][moveColumna-1]==1&&matrizCaminos[moveFila-1][moveColumna-1]==1){
                                    //choco con un muro por el frente y por arriba, por el cual debe caminar hacia la izquierda para buscar una por arriba y sino devuelva por donde viene
                                    if (matrizCaminos[moveFila][moveColumna-2]!=1 &&matrizOfWall[moveFila][moveColumna-2]!=1) {
                                        
                                                Boolean marchaAtras=true;
                                                
                                                while(marchaAtras){
                                                    if (moveColumna-1==0) {
                                                       decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                }     
                                                    else if (matrizOfWall[moveFila+1][moveColumna-2]!=1&&matrizCaminos[moveFila+1][moveColumna-2]!=1 && matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                        //encontro una salida por un posicion atras y por arriba
                                                        
                                                        matrizCaminos[moveFila][moveColumna-2]=1;
                                                        moveColumna--;
                                                        g.clearRect( initX, initY+10, 30, 30);
                                                        g.setColor(Color.BLACK);
                                                        g.drawRect(initX, initY, 50, 50);
                                                        initX-=50;
                                                        g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                                       
                                                        decisions=false;
                                                        marchaAtras=false;
                                                }
                                                else{
                                                    if (matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                            
                                                            matrizCaminos[moveFila][moveColumna-2]=1;
                                                            moveColumna--;
                                                            g.clearRect( initX, initY+10, 30, 30);
                                                            g.setColor(Color.BLACK);
                                                            g.drawRect(initX, initY, 50, 50);
                                                            initX-=50;
                                                            g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                                                    }
                                                    else{ 
                                                        decisions=false;
                                                        marchaAtras=false;
                                                        debeVolver=true;
                                                        
                                                    }
                                                    
                                                    }
                                                    try{
                                                        sleep(200);
                                                    }
                                                    catch(Exception ex){
                                                    
                                                    }
                                                }//fin del while marcha atras 
                                        
                                    }
                                    else{
                                        decisions=false;
                                        debeVolver=true;
                                    }
                                   
                                    
                                     
                                }
                                else if (matrizOfWall[moveFila+1][moveColumna]==1) {
                                    matrizCaminos[moveFila+1][moveColumna-1]=1;
                                    moveFila++;
                                    g.clearRect( initX, initY+10, 30, 30);
                                    g.setColor(Color.BLACK);
                                    g.drawRect(initX, initY, 50, 50);
                                    initY+=50;
                                    g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                                    
                                }
                                else{
                                    if (matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                                        //va para abajo
                                        moveFila++;
                                        g.clearRect( initX, initY+10, 30, 30);
                                        g.setColor(Color.BLACK);
                                        g.drawRect(initX, initY, 50, 50);
                                        initY+=50;
                                        g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                                        decisions=false;
                                    }
                                    else{
                                        //solamente si no ha subido puede bajar
                                        if (matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                                             moveFila--;
                                            g.clearRect( initX, initY+10, 30, 30);
                                            g.setColor(Color.BLACK);
                                            g.drawRect(initX, initY, 50, 50);
                                            initY-=50;
                                            g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                                            decisions=false;
                                    }
                                        else{
                                            if (matrizCaminos[moveFila][moveColumna-2]!=1) {
                                                if (moveFila==0) {
                                                    if (matrizOfWall[moveFila+1][moveColumna-2]!=1 && matrizCaminos[moveFila+1][moveColumna-2]!=1) {
                                                        decisions=false;
                                                    }
                                                    else{
                                                        Boolean marchaAtras=true;
                                                        while(marchaAtras){
                                                        if (moveColumna-1==0) {
                                                               decisions=false;
                                                                marchaAtras=false;
                                                                debeVolver=true;
                                                        }     
                                                        else if (matrizOfWall[moveFila+1][moveColumna-2]!=1&&matrizCaminos[moveFila+1][moveColumna-2]!=1) {
                                                            decisions=false;
                                                            marchaAtras=false;
                                                        }
                                                        else{
                                                            if (matrizOfWall[moveFila][moveColumna-2]!=1) {
                                                                    matrizCaminos[moveFila][moveColumna-2]=1;
                                                                    moveColumna++;
                                                                    g.clearRect( initX, initY+10, 30, 30);
                                                                    g.setColor(Color.BLACK);
                                                                    g.drawRect(initX, initY, 50, 50);
                                                                    initX+=50;
                                                                    g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                                                            }
                                                            else{ 
                                                                decisions=false;
                                                                marchaAtras=false;
                                                                debeVolver=true;

                                                            }

                                                            }
                                                            try{
                                                                sleep(200);
                                                            }
                                                            catch(Exception ex){

                                                            }
                                                        } 
                                                    
                                                    
                                                    
                                                    }
                                                    
                                                }
                                            else if ((matrizOfWall[moveFila-1][moveColumna-2]!=1&&matrizCaminos[moveFila-1][moveColumna-2]!=1) || (matrizOfWall[moveFila+1][moveColumna-2]!=1&&matrizCaminos[moveFila+1][moveColumna-2]!=1)) {
                                                //metase por ahi
                                                decisions=false;
                                            }
                                            else{
                                                
                                            matrizCaminos[moveFila][moveColumna-2]=1;
                                            moveColumna--;
                                            g.clearRect( initX, initY+10, 30, 30);
                                            g.setColor(Color.BLACK);
                                            g.drawRect(initX, initY, 50, 50);
                                            initX-=50;
                                            g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                                            }
//                                                JOptionPane.showMessageDialog(null, "El toque es que si tiene que aplicar reversa");
                                            }
                                        
                                        
                                        }
                                        //JOptionPane.showMessageDialog(null, "no puedo pasar donde ya pase");
                                    
                                    }
                                   
                                }
                            try{
                                sleep(500);
                            }catch(Exception ex){}
                            }
                    }
                    }
                    else{
                        int decision= (int)(Math.random()*2);
                        if (decision==0) {
                            if (matrizOfWall[moveFila-1][moveColumna-1]!=1 && matrizCaminos[moveFila-1][moveColumna-1]!=1) {
                                matrizCaminos[moveFila-1][moveColumna-1]=1;
                                moveFila--;
                                g.clearRect( initX, initY+10, 30, 30);
                                g.setColor(Color.BLACK);
                                g.drawRect(initX, initY, 50, 50);
                                initY-=50;
                                g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                    }
                    }
                    else{
                        if (matrizOfWall[moveFila+1][moveColumna-1]!=1 && matrizCaminos[moveFila+1][moveColumna-1]!=1) {
                            matrizCaminos[moveFila+1][moveColumna-1]=1;
                            moveFila++;
                            g.clearRect( initX, initY+10, 30, 30);
                            g.setColor(Color.BLACK);
                            g.drawRect(initX, initY, 50, 50);
                            initY+=50;
                            g.drawImage(bufferedPersonaje4, initX, initY+10, 30, 30, null);
                    }
                    }          
                    }
                }
                }
                try{
                    sleep(500);
                }catch(Exception ex){}
            }
        }
    }.start();
}   
    
    public void  chronometer(JLabel lb_chronometer) {
        new Thread(){
        public void run(){
        while(true){
            try{
                Thread.sleep(999);
                sec++;
                if(sec>=59){
                    min++;
                    sec =0;
                    
                }
                lb_chronometer.setText(String.format("%02d",min)+" : "+ String.format("%02d",sec));
                
            }catch(Exception e){
                
            }
        }
    }
        }.start();
        
                }
}
                
