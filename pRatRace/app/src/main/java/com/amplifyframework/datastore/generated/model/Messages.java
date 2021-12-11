package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.core.model.annotations.HasMany;

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

/** This is an auto generated class representing the Messages type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Messages", authRules = {
  @AuthRule(allow = AuthStrategy.PRIVATE, operations = { ModelOperation.CREATE, ModelOperation.READ })
})
public final class Messages implements Model {
  public static final QueryField ID = field("Messages", "id");
  public static final QueryField MESSAGES = field("Messages", "messages");
  public static final QueryField DATE = field("Messages", "date");
  public static final QueryField USER = field("Messages", "user");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String messages;
  private final @ModelField(targetType="AWSDateTime") Temporal.DateTime date;
  private final @ModelField(targetType="String") String user;
  private final @ModelField(targetType="AppUserMessages") @HasMany(associatedWith = "messages", type = AppUserMessages.class) List<AppUserMessages> appusers = null;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getMessages() {
      return messages;
  }
  
  public Temporal.DateTime getDate() {
      return date;
  }
  
  public String getUser() {
      return user;
  }
  
  public List<AppUserMessages> getAppusers() {
      return appusers;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Messages(String id, String messages, Temporal.DateTime date, String user) {
    this.id = id;
    this.messages = messages;
    this.date = date;
    this.user = user;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Messages messages = (Messages) obj;
      return ObjectsCompat.equals(getId(), messages.getId()) &&
              ObjectsCompat.equals(getMessages(), messages.getMessages()) &&
              ObjectsCompat.equals(getDate(), messages.getDate()) &&
              ObjectsCompat.equals(getUser(), messages.getUser()) &&
              ObjectsCompat.equals(getCreatedAt(), messages.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), messages.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getMessages())
      .append(getDate())
      .append(getUser())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Messages {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("messages=" + String.valueOf(getMessages()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("user=" + String.valueOf(getUser()) + ", ")
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
  public static Messages justId(String id) {
    return new Messages(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      messages,
      date,
      user);
  }
  public interface BuildStep {
    Messages build();
    BuildStep id(String id);
    BuildStep messages(String messages);
    BuildStep date(Temporal.DateTime date);
    BuildStep user(String user);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String messages;
    private Temporal.DateTime date;
    private String user;
    @Override
     public Messages build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Messages(
          id,
          messages,
          date,
          user);
    }
    
    @Override
     public BuildStep messages(String messages) {
        this.messages = messages;
        return this;
    }
    
    @Override
     public BuildStep date(Temporal.DateTime date) {
        this.date = date;
        return this;
    }
    
    @Override
     public BuildStep user(String user) {
        this.user = user;
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
    private CopyOfBuilder(String id, String messages, Temporal.DateTime date, String user) {
      super.id(id);
      super.messages(messages)
        .date(date)
        .user(user);
    }
    
    @Override
     public CopyOfBuilder messages(String messages) {
      return (CopyOfBuilder) super.messages(messages);
    }
    
    @Override
     public CopyOfBuilder date(Temporal.DateTime date) {
      return (CopyOfBuilder) super.date(date);
    }
    
    @Override
     public CopyOfBuilder user(String user) {
      return (CopyOfBuilder) super.user(user);
    }
  }
  
}
