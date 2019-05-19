
package modelo;

import java.util.ArrayList;
import vista.Interf;


public class Juegocompletar {
    
    public ArrayList<Objetosp> preguntas=new ArrayList();
    public ArrayList<Objetosr> respuestas=new ArrayList();
    public ArrayList<Objetosin> ingresar=new ArrayList();
    
    private int conteo = 0;
    private int conteor= 0;
    private int conteoin=0;
    private int conteoimag=0;
    
    
    public Juegocompletar(){
        Objetosp p1=new Objetosp("¿ Con la invasión de Alemania a el pais polaco inicia lo que se llamaria la segunda guerra mundial. Siendo el conflicto mas mortifero en la historia de la humanidad, durando 6 años y un dia. La guerra mundial termino el 2 de septiembre de 1945 y comenzo el...");//1 septiebre de 1939
        Objetosp p2=new Objetosp("¿El Ataque terrorista que marcaron la historia de los Estados Unidos de America, seria un atentado de grandes magnitudes organizado por el grupo al-Qaeda quien con sus integrantes lograron penetrar la seguridad y lograr parte de su plan. Este hecho ocurriria el 11 de septiembre de 2001 en la ciudad de...");//Nueva york
        Objetosp p3=new Objetosp("¿Existe una cordillera que se situa en el continente de Asia, siendo la cordillera con mas altura en la tierra, en la cual se encuetra uno de los picos mas emblematicos y conocidos el 'Monte Everest', esta cordillera tan importante y emblemantica tiene el nombre de...?");//Himalaya
        Objetosp p4=new Objetosp("¿Un pais marcado por su historia, que constantemente ha sido vista como una historia llena de corrupcion politica en mandato de dictadores tiene como ubicación en hermoso mar caribe, y como capital La Habana?");//Cuba<3
        Objetosp p5=new Objetosp("¿Situado entre los océanos Atlántico, al oeste, el Índico, al este, ademas de tener como ecosistema predominante la sabana y el desierto se encuentra uno de los continentes mas grandes de el planeta habitad de animales salvajes. Su nombre es...");//Africa
        Objetosp p6=new Objetosp("¿Una de las maravillas del mundo mas hermosas, ubicada en el continente asiatico se logra observar desde el espacio, esta obra maravillosa tiene como nombre La gran...?");
        Objetosp p7=new Objetosp("¿Continenete ubicado en el hemisferio sur del planeta tierra, hogar de pinguinos y ballenas azules?");
        Objetosp p8=new Objetosp("¿Formando parte de el Oceano Pacífico se encuentra un continente lleno de islas a su alrededor, continente donde predomina el pais de Australia lugar de conguros, el continente tiene el nombre de...");
        Objetosp p9=new Objetosp("¿En europa se encuentra una de las maravillas arquitectonicas mas imponentes de la actualidad, una torre de hierro con una altura de 324 metros que lleva el nombre de su contructor el senor Alexandre Gustave ...?");
        Objetosp p10=new Objetosp("¿Uno de los paises latinoamericanos bañado por el pacifico y el atlantico, representado por su cultura folclorica, sus montañas y extensas llanuras, ademas de la su representación cafetera a nivel internacional tiene el nombre de...");
        
        Objetosr p01=new Objetosr("1 D_ SE_T_EM__E DE 1_3_");
        Objetosr p02=new Objetosr("N_W YO_K");
        Objetosr p03=new Objetosr("H__A_AYA");
        Objetosr p04=new Objetosr("_U_A");
        Objetosr p05=new Objetosr("A__I__");
        Objetosr p06=new Objetosr("M_UR__LA CHI_A");
        Objetosr p07=new Objetosr("A_T_RT_DA");
        Objetosr p08=new Objetosr("O_E__IA");
        Objetosr p09=new Objetosr("E_FF_L");
        Objetosr p010=new Objetosr("C_LOM_I_");
        
        Objetosin p001=new Objetosin("1 de septiembre de 1939");
        Objetosin p002=new Objetosin("New York");
        Objetosin p003=new Objetosin("Himalaya");
        Objetosin p004=new Objetosin("Cuba");
        Objetosin p005=new Objetosin("Africa");
        Objetosin p006=new Objetosin("Muralla china");
        Objetosin p007=new Objetosin("Antartida");
        Objetosin p008=new Objetosin("Oceania");
        Objetosin p009=new Objetosin("Eiffel");
        Objetosin p0010=new Objetosin("Colombia");
        
        preguntas.add(p1);
        preguntas.add(p2);
        preguntas.add(p3);
        preguntas.add(p4);
        preguntas.add(p5);
        preguntas.add(p6);
        preguntas.add(p7);
        preguntas.add(p8);
        preguntas.add(p9);
        preguntas.add(p10);
      
        respuestas.add(p01);
        respuestas.add(p02);
        respuestas.add(p03);
        respuestas.add(p04);
        respuestas.add(p05);
        respuestas.add(p06);
        respuestas.add(p07);
        respuestas.add(p08);
        respuestas.add(p09);
        respuestas.add(p010);
        
        ingresar.add(p001);
        ingresar.add(p002);
        ingresar.add(p003);
        ingresar.add(p004);
        ingresar.add(p005);
        ingresar.add(p006);
        ingresar.add(p007);
        ingresar.add(p008);
        ingresar.add(p009);
        ingresar.add(p0010);

    }
    
    public String Recorrer(String preguntaa){
        String a = preguntas.get(conteo).toString();
        conteo++;//aumenta una posicion en elarreglo
            if(conteo==10){
                conteo=0;
            }
        return a;
    } 

    public String Recorrerr(String respuestaa){
        String b = respuestas.get(conteor).toString();
        conteor++;
            if(conteor==10){
                conteor=0;
            }
        return b;
    }
    
    public String Recorerrr(String ingresado){
        String c= ingresar.get(conteoin).toString();
        conteoin++;
            if(conteoin==10){
                conteoin=0;
            }
        return c;
    }
    
    public String Textoinfo(){
        String tex = "Felicidades!\nEspera la siguiente pregunta"; 
        return tex;
    }    
}