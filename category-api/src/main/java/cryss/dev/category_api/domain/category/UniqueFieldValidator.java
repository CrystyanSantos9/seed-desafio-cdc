package cryss.dev.category_api.domain.category;

public interface UniqueFieldValidator {
    Boolean isValid(Object object);

     Boolean accept(Object object);
}
