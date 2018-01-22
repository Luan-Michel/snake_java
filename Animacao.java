//******************************************************************************
//Código implementado por: Luan Michel dos Santos
//Implementado para obtenção da nota semestral da matéria de Computação Gráfica
//Junho de 2017
//******************************************************************************

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.util.*;
import java.awt.image.BufferedImage;
import javax.swing.Timer;

public class Animacao implements ActionListener
{
  private int tam = 30;
  private BufferedImageDrawer buffid;
  private AffineTransform af,aft, rot, in, out;
  private Rectangle2D rect, maca, odir, oesq, ling;
  private int x=0,y=0, comp=1;
  private LinkedList<Cobra> cobra;
  private Random random = new Random();
  private int px, py, d, antdir=2;
  private Timer tempo;
  private boolean lingua = true, first=false;
  
  Animacao(BufferedImageDrawer bid, int width, int height,int delay)
  {
        d = delay;
        tempo = new Timer(d, this);
        cobra = new LinkedList();
        cobra.add(new Cobra(x,y));
        //System.out.println("x "+xList.get(0)+" y"+yList.get(0));
        px = 7;
        py = 7;
        System.out.println(px+"-"+px*tam);
        System.out.println(py+"-"+py*tam+"---");
	af = new AffineTransform();
	in = new AffineTransform();
        aft = new AffineTransform();
        rot = new AffineTransform();
        out = new AffineTransform();
	rect = new Rectangle2D.Double(tam,tam,tam,tam);
	odir = new Rectangle2D.Double(tam+10, tam+7, 5, 5);
	oesq = new Rectangle2D.Double(tam+10,tam+18, 5, 5);
	ling = new Rectangle2D.Double(1.9*tam,tam+(tam/2)-2, 7, 3);
	maca = new Rectangle2D.Double(tam,tam,tam,tam);
        buffid = bid;
        tempo.start();
  }
  
  public int getD(){
      return d;
  }

  public void run()
  {
    if(buffid.play == false){
        if(lingua){
            buffid.g2dbi.setColor(Color.green);
            //S
            buffid.g2dbi.fillRect(2*tam,5*tam,3*tam,tam);
            buffid.g2dbi.fillRect(2*tam,5*tam,tam,3*tam);
            buffid.g2dbi.fillRect(2*tam,7*tam,3*tam,tam);
            buffid.g2dbi.fillRect(4*tam,7*tam,tam,3*tam);
            buffid.g2dbi.fillRect(2*tam,9*tam,3*tam,tam);
            
            //N
            buffid.g2dbi.fillRect(6*tam,5*tam,tam,5*tam);
            buffid.g2dbi.fillRect(7*tam,6*tam,tam,tam);
            buffid.g2dbi.fillRect(8*tam,7*tam,tam,tam);
            buffid.g2dbi.fillRect(9*tam,8*tam,tam,tam);
            
            buffid.g2dbi.fillRect(10*tam,5*tam,tam,5*tam);
            
            //A
            buffid.g2dbi.fillRect(12*tam,5*tam,tam,5*tam);
            buffid.g2dbi.fillRect(13*tam,5*tam,tam,tam);
            buffid.g2dbi.fillRect(13*tam,7*tam,tam,tam);
            buffid.g2dbi.fillRect(14*tam,5*tam,tam,5*tam);
            
            //K
            buffid.g2dbi.fillRect(16*tam,5*tam,tam,5*tam);
            buffid.g2dbi.fillRect(19*tam,5*tam,tam,tam);
            buffid.g2dbi.fillRect(18*tam,6*tam,tam,tam);
            buffid.g2dbi.fillRect(17*tam,7*tam,tam,tam);
            buffid.g2dbi.fillRect(18*tam,8*tam,tam,tam);
            buffid.g2dbi.fillRect(19*tam,9*tam,tam,tam);
            
            //E
            buffid.g2dbi.fillRect(21*tam,5*tam,tam,5*tam);
            buffid.g2dbi.fillRect(21*tam,5*tam,3*tam,tam);
            buffid.g2dbi.fillRect(21*tam,7*tam,3*tam,tam);
            buffid.g2dbi.fillRect(21*tam,9*tam,3*tam,tam);

            buffid.g2dbi.setColor(Color.white);
            lingua=false;
        }else{
            buffid.g2dbi.setColor(Color.black);
            buffid.g2dbi.fillRect(0, 0, 800, 600);
            buffid.g2dbi.setColor(Color.white);
            lingua=true;
        }
        for(int i=0;i<=800;i+=tam){
            buffid.g2dbi.drawLine(i,tam,i,600-tam);
        }
        for(int i=0;i<=600;i+=tam){
            buffid.g2dbi.drawLine(tam,i,800-tam,i);
        }
        buffid.repaint();
    }else{
        if(!first){
            buffid.g2dbi.setColor(Color.black);
            buffid.g2dbi.fillRect(0, 0, 800, 600);
            buffid.g2dbi.setColor(Color.white);
            lingua=true;
            first=true;
        }
        System.out.println("X="+x+"  X*tam="+x*tam);
        System.out.println("Y="+y+"  Y*tam="+y*tam+"\n");
        int ax = x, ay = y;
        if(x == px && y == py){
            px = (random.nextInt(((int)720/tam)-2))+1;
            py = (random.nextInt(((int)510/tam)-2))+1;
            comp++;
            d = (int)(d - d/10);
            tempo.setDelay(d);
        }

        //apaga cara
        if(comp >=1)
            buffid.g2dbi.fillRect(ax*tam+tam,ay*tam+tam,tam,tam);

        //verifica direção
        if(buffid.direcao == 0){
            if(buffid.mudir){
                buffid.g2dbi.setColor(Color.BLACK);
                if(antdir == 2){
                    buffid.g2dbi.fillRect((x+1)*tam+tam,y*tam+tam,tam,tam);
                }else if(antdir == 3){
                    buffid.g2dbi.fillRect((x-1)*tam+tam,y*tam+tam,tam,tam);
                }
                antdir = 0;
                buffid.mudir = false;
            }
            buffid.g2dbi.setColor(Color.green);
            y--;
        }else if(buffid.direcao == 1){
            if(buffid.mudir){
                buffid.g2dbi.setColor(Color.BLACK);
                if(antdir == 2){
                    buffid.g2dbi.fillRect((x+1)*tam+tam,y*tam+tam,tam,tam);
                }else if(antdir == 3){
                    buffid.g2dbi.fillRect((x-1)*tam+tam,y*tam+tam,tam,tam);
                }
                antdir = 1;
                buffid.mudir = false;
            }
            buffid.g2dbi.setColor(Color.green);
            y++;
        }else if(buffid.direcao == 2 && x*tam < 720){
            if(buffid.mudir){
                buffid.g2dbi.setColor(Color.BLACK);
                if(antdir == 0){
                    buffid.g2dbi.fillRect(x*tam+tam,(y-1)*tam+tam,tam,tam);
                }else if(antdir == 1){
                    buffid.g2dbi.fillRect((x)*tam+tam,(y+1)*tam+tam,tam,tam);
                }
                antdir = 2;
                buffid.mudir = false;
            }
            buffid.g2dbi.setColor(Color.green);
            x++;
        }else if(buffid.direcao ==3 && x*tam > 0){
            if(buffid.mudir){
                buffid.g2dbi.setColor(Color.BLACK);
                if(antdir == 0){
                    buffid.g2dbi.fillRect((x)*tam+tam,(y-1)*tam+tam,tam,tam);
                }else if(antdir == 1){
                    buffid.g2dbi.fillRect((x)*tam+tam,(y+1)*tam+tam,tam,tam);
                }
                antdir = 3;
                buffid.mudir = false;
            }
            buffid.g2dbi.setColor(Color.green);
            x--;
        }
        if(y*tam < 0 || y*tam >510
                || x*tam > 720 || x*tam < 0 ||
                cobra.contains(new Cobra(x,y)) ){
            System.exit(0);
        }
        cobra.add(new Cobra(x,y));
        //System.out.println("1x "+xList.get(0)+" 2y"+yList.get(0));
        //System.out.println("ex "+xList.get(1)+" ey"+yList.get(1));
        buffid.g2dbi.setColor(Color.black);
        if(px != x || py != y){
            Cobra c = cobra.get(0);
            buffid.g2dbi.fillRect(c.x*tam+tam,c.y*tam+tam,tam,tam);
            cobra.remove(0);       
            //yList.remove(0);
        }
        buffid.g2dbi.setColor(Color.white);
        for(int i=0;i<=800;i+=tam){
            buffid.g2dbi.drawLine(i,tam,i,600-tam);
        }
        for(int i=0;i<=600;i+=tam){
            buffid.g2dbi.drawLine(tam,i,800-tam,i);
        }
        af.setToTranslation(px*tam,py*tam);
        aft.setToTranslation(x*tam,y*tam);

          //translation of eyes
          switch (buffid.direcao) {
              case 1:
                  rot.setToRotation(Math.toRadians(90));
                  in.setToTranslation(-tam, -tam);
                  out.setToTranslation(2*tam, tam);
                  break;
              case 2:
                  rot.setToRotation(Math.toRadians(0));
                  in.setToTranslation(-tam, -tam);
                  out.setToTranslation(tam, tam);
                  break;
              case 0:
                  rot.setToRotation(Math.toRadians(-90));
                  in.setToTranslation(-tam, -tam);
                  out.setToTranslation(tam, 2*tam);
                  break;
              case 3:
                  rot.setToRotation(Math.toRadians(180));
                  in.setToTranslation(-tam, -tam);
                  out.setToTranslation(2*tam, 2*tam);
                  break;
              default:
                  break;
          }

        //aft.concatenate(af);
        buffid.g2dbi.setColor(Color.red);
        buffid.g2dbi.fill(af.createTransformedShape(maca));
        buffid.g2dbi.setColor(Color.green);
        buffid.g2dbi.fill(aft.createTransformedShape(rect));
        buffid.g2dbi.setColor(Color.black);
        buffid.g2dbi.fill(aft.createTransformedShape(out.createTransformedShape(rot.createTransformedShape(in.createTransformedShape(oesq)))));
        buffid.g2dbi.fill(aft.createTransformedShape(out.createTransformedShape(rot.createTransformedShape(in.createTransformedShape(odir)))));
        buffid.g2dbi.setColor(Color.RED);
        if(lingua){
            buffid.g2dbi.fill(aft.createTransformedShape(out.createTransformedShape(rot.createTransformedShape(in.createTransformedShape(ling)))));
            lingua= false;
        }
        else
            lingua = true;
        //buffid.g2dbi.fill(ling);
        //buffid.g2dbi.fill(aft.createTransformedShape(rot.createTransformedShape(odir)));
        //buffid.g2dbi.fill(aft.createTransformedShape(odir));
        buffid.g2dbi.setColor(Color.green);
        buffid.repaint();
    }
  }

  public static void main(String[] argv)
  {

    int width = 800;
    int height = 600;
    int delay = 500;

    BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

    BufferedImageDrawer bid = new BufferedImageDrawer(bi,width,height);

    //Timer t = new Timer();
    
    Animacao an = new Animacao(bid,width,height,delay);
    
    //t.schedule(an,0,delay);
    
  }

    @Override
    public void actionPerformed(ActionEvent e) {
        run();
    }


}


