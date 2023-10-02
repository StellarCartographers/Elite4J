package elite.dangerous.journal.models.scan;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import elite.dangerous.journal.models.enums.BodyType;
import elite.dangerous.utils.adapter.ParentsAdapter;
import lombok.AllArgsConstructor;

@JsonDeserialize(using = ParentsAdapter.class)
public class Parents
{
    ArrayList<Parent> list = new ArrayList<>();
    
    
    public boolean add(String type, int bodyID)
    {
        return this.list.add(new Parent(BodyType.fromString(type), bodyID));
    }
    
    public int parentCount()
    {
        return this.list.size();
    }
    
    public List<Parent> listFromBodyType(BodyType bodyType)
    {
        return this.list.stream().filter(p -> p.type.equals(bodyType)).collect(Collectors.toList());
    }
    
    public Parent[] arrayFromBodyType(BodyType bodyType)
    {
        return listFromBodyType(bodyType).toArray(new Parent[0]);
    }

    @AllArgsConstructor
    static class Parent
    {
        public final BodyType type;

        public final int bodyID;
    }
}
