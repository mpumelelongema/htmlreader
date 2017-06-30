package za.co.egis.assessment;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TechnologyStack {
    private String stack;
    private List<String> technologies = new ArrayList<>();
}
