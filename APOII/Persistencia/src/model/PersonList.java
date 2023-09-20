package model;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonList {
    private List<Person> people;
    private File dataFolder;
    private File result;
    private File jsonFile;

    // lo que hicimos en el constructor fue organizar donde vamos a meter la info
    public PersonList(){
        people = new ArrayList<>();
        // como obtener la ruta relativa o absoluta del proyecto en el que estoy parado
        // en este caso, obtenemos la ruta absoluta
        File projectDir = new File(System.getProperty("user.dir"));
        dataFolder = new File(projectDir+"/data");
        result = new File(dataFolder+"result.txt");
        jsonFile = new File(dataFolder+"people.json");
    }
    // por que es que esto manda esta excepcion?
    public void createResources() throws IOException {
        if(!dataFolder.exists()){
            // si no existe, crea la carpeta
            dataFolder.mkdir();
            if (!result.exists()){
                // por seguridad, si el archivo no existe, creo el archivo
                result.createNewFile();
            }
            if(!jsonFile.exists()){
                jsonFile.createNewFile();
            }
        }
    }
    // crear metodo para guardar la info
    // tira excepcion cuando no encuentra el archivo.
    public void save() throws IOException {
        createResources();
        // manejamos nuestra fuente de informacion
        // result --> fuente de informacion (archivo)
        // FileOutPutStream --> especie de enlazador. conecta
        // el lenguaje (en este caso Java) con la fuente de informacion.
        FileOutputStream fos = new FileOutputStream(result);// esto es susceptible de lanzar una filenotfoundexception
        //fuente de la informacion
        // definir el formato
        String data = "";
        for (int i = 0; i < people.size(); i++) {
            data += people.get(i).getName() + ","+ people.get(i).getID()+ ","+people.get(i).getYear() + "\n";
        }
        //BufferedWriter --> escribe la informacion. para funcionar necesita
        // el outputstream --> que es un empaquetador de la informacion, prepara el recurso donde queremos escribir.
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        writer.write(data); // susceptible de lanzar una IOException
        // el método flush borra toda la información del writer
        writer.flush();
        // despues de finalizar el programma el bufferedWriter puede quedar abierto,
        // entonces debemos cerrarlo.
        writer.close();
    }
    public void load() throws IOException {
        FileInputStream fis = new FileInputStream(result);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

        String content = "";
        String line = "";
        while ( (line = reader.readLine()) != null){
            content += line;
            // atributo de los strings que me permite crear arreglos
            // el split recibe un delimitador, cada elemento separado por la coma
            // ira en un indice del arreglo.
            String[] arr = content.split(",");
            people.add(new Person(arr[0], arr[1], Integer.parseInt(arr[2])));
        }
        // cierro el proceso
        reader.close();
    }
    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
    public void saveToGson() throws IOException {
        // crear los recursos (archivos y carpetas)
        createResources();
        // serializador de la informacion
        Gson gson = new Gson();

        FileOutputStream fos = new FileOutputStream(jsonFile);// esto es susceptible de lanzar una filenotfoundexception

        String data = gson.toJson(people);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        writer.write(data); // susceptible de lanzar una IOException
        // el método flush borra toda la información del writer
        writer.flush();
        writer.close();
    }
    public void loadFromGson() throws IOException {
        Gson gson = new Gson();
        FileInputStream fis = new FileInputStream(jsonFile);

        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        String content = "";
        String line = "";
        while ( (line = reader.readLine()) != null){
            content += line;
        }
        // cierro el proceso
        reader.close();
        Person[] persons = gson.fromJson(content, Person[].class);
        people = Arrays.asList(persons);
       /* for (Person p: persons) {

        }*/
    }
}
























