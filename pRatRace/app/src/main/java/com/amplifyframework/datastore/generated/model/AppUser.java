package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.HasMany;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the AppUser type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "AppUsers", authRules = {
  @AuthRule(allow = AuthStrategy.PRIVATE, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class AppUser implements Model {
  public static final QueryField ID = field("AppUser", "id");
  public static final QueryField NAME = field("AppUser", "name");
  public static final QueryField EMAIL = field("AppUser", "email");
  public static final QueryField MESSAGE = field("AppUser", "message");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String name;
  private final @ModelField(targetType="AWSEmail") String email;
  private final @ModelField(targetType="String") String message;
  private final @ModelField(targetType="AppUserMessages") @HasMany(associatedWith = "appUser", type = AppUserMessages.class) List<AppUserMessages> textMessages = null;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getName() {
      return name;
  }
  
  public String getEmail() {
      return email;
  }
  
  public String getMessage() {
      return message;
  }
  
  public List<AppUserMessages> getTextMessages() {
      return textMessages;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private AppUser(String id, String name, String email, String message) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.message = message;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      AppUser appUser = (AppUser) obj;
      return ObjectsCompat.equals(getId(), appUser.getId()) &&
              ObjectsCompat.equals(getName(), appUser.getName()) &&
              ObjectsCompat.equals(getEmail(), appUser.getEmail()) &&
              ObjectsCompat.equals(getMessage(), appUser.getMessage()) &&
              ObjectsCompat.equals(getCreatedAt(), appUser.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), appUser.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getEmail())
      .append(getMessage())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("AppUser {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("email=" + String.valueOf(getEmail()) + ", ")
      .append("message=" + String.valueOf(getMessage()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static BuildStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static AppUser justId(String id) {
    return new AppUser(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      email,
      message);
  }
  public interface BuildStep {
    AppUser build();
    BuildStep id(String id);
    BuildStep name(String name);
    BuildStep email(String email);
    BuildStep message(String message);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String name;
    private String email;
    private String message;
    @Override
     public AppUser build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new AppUser(
          id,
          name,
          email,
          message);
    }
    
    @Override
     public BuildStep name(String name) {
        this.name = name;
        return this;
    }
    
    @Override
     public BuildStep email(String email) {
        this.email = email;
        return this;
    }
    
    @Override
     public BuildStep message(String message) {
        this.message = message;
        return this;
    }
    
    /** 
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String name, String email, String message) {
      super.id(id);
      super.name(name)
        .email(email)
        .message(message);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder email(String email) {
      return (CopyOfBuilder) super.email(email);
    }
    
    @Override
     public CopyOfBuilder message(String message) {
      return (CopyOfBuilder) super.message(message);
    }
  }
  
}
