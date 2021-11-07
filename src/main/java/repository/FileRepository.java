package repository;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;

public abstract class FileRepository<T> extends InMemoryRepository<T>{
    protected File file;

    public FileRepository(){
        super();
    }

    @Override
    public T create(T obj) throws IOException {
        super.create(obj);
        writeToFile();
        return obj;
    }

    @Override
    public void delete(T obj) throws IOException {
        super.delete(obj);
        writeToFile();
    }

    public void writeToFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(file, repoList);
    }


    public T update(T obj){
        return null;
    }
}
