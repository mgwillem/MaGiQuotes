package org.magi.quotes.core.util;

import java.util.Set;
import javax.validation.ConstraintViolation;

/**
 * @author MGW
 */
@javax.ejb.ApplicationException(rollback=false)
public class ApplicationException extends Exception
{
    private Set<ConstraintViolation<?>> violations;
    
    public ApplicationException(){
        
    }
    
    public ApplicationException(String message) {
        super(message);
    }
    
    public ApplicationException(Throwable cause) {
        super(cause);
    }
    
    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public ApplicationException(Set<ConstraintViolation<?>> violations) {
        this.violations = violations;
    }

    public Set<ConstraintViolation<?>> getViolations() {
        return violations;
    }

    public void setViolations(Set<ConstraintViolation<?>> violations) {
        this.violations = violations;
    }
}
