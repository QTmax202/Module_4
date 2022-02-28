package cg.formatter;

import cg.model.Classes;
import cg.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class ClassFormatter implements Formatter<Classes> {
    @Autowired
    private IClassService iClassService;

    @Autowired
    public ClassFormatter(IClassService iClassService) {
        this.iClassService = iClassService;
    }

    @Override
    public Classes parse(String text, Locale locale) throws ParseException {
        return iClassService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Classes object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
