package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.BelongsTo;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the AppUserMessages type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "AppUserMessages")
public final class AppUserMessages implements Model {
  public static final QueryField ID = field("AppUserMessages", "id");
  public static final QueryField MESSAGES_ID = field("AppUserMessages", "messagesID");
  public static final QueryField APP_USER_ID = field("AppUserMessages", "appUserID");
  public static final QueryField MESSAGES = field("AppUserMessages", "messagesID");
  public static final QueryField APP_USER = field("AppUserMessages", "appUserID");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String messagesID;
  private final @ModelField(targetType="ID", isRequired = true) String appUserID;
  private final @ModelField(targetType="Messages", isRequired = true) @BelongsTo(targetName = "messagesID", type = Messages.class) Messages messages;
  private final @ModelField(targetType="AppUser", isRequired = true) @BelongsTo(targetName = "appUserID", type = AppUser.class) AppUser appUser;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getMessagesId() {
      return messagesID;
  }
  
  public String getAppUserId() {
      return appUserID;
  }
  
  public Messages getMessages() {
      return messages;
  }
  
  public AppUser getAppUser() {
      return appUser;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private AppUserMessages(String id, String messagesID, String appUserID, Messages messages, AppUser appUser) {
    this.id = id;
    this.messagesID = messagesID;
    this.appUserID = appUserID;
    this.messages = messages;
    this.appUser = appUser;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      AppUserMessages appUserMessages = (AppUserMessages) obj;
      return ObjectsCompat.equals(getId(), appUserMessages.getId()) &&
              ObjectsCompat.equals(getMessagesId(), appUserMessages.getMessagesId()) &&
              ObjectsCompat.equals(getAppUserId(), appUserMessages.getAppUserId()) &&
              ObjectsCompat.equals(getMessages(), appUserMessages.getMessages()) &&
              ObjectsCompat.equals(getAppUser(), appUserMessages.getAppUser()) &&
              ObjectsCompat.equals(getCreatedAt(), appUserMessages.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), appUserMessages.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getMessagesId())
      .append(getAppUserId())
      .append(getMessages())
      .append(getAppUser())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("AppUserMessages {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("messagesID=" + String.valueOf(getMessagesId()) + ", ")
      .append("appUserID=" + String.valueOf(getAppUserId()) + ", ")
      .append("messages=" + String.valueOf(getMessages()) + ", ")
      .append("appUser=" + String.valueOf(getAppUser()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static MessagesIdStep builder() {
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
  public static AppUserMessages justId(String id) {
    return new AppUserMessages(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      messagesID,
      appUserID,
      messages,
      appUser);
  }
  public interface MessagesIdStep {
    AppUserIdStep messagesId(String messagesId);
  }
  

  public interface AppUserIdStep {
    MessagesStep appUserId(String appUserId);
  }
  

  public interface MessagesStep {
    AppUserStep messages(Messages messages);
  }
  

  public interface AppUserStep {
    BuildStep appUser(AppUser appUser);
  }
  

  public interface BuildStep {
    AppUserMessages build();
    BuildStep id(String id);
  }
  

  public static class Builder implements MessagesIdStep, AppUserIdStep, MessagesStep, AppUserStep, BuildStep {
    private String id;
    private String messagesID;
    private String appUserID;
    private Messages messages;
    private AppUser appUser;
    @Override
     public AppUserMessages build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new AppUserMessages(
          id,
          messagesID,
          appUserID,
          messages,
          appUser);
    }
    
    @Override
     public AppUserIdStep messagesId(String messagesId) {
        Objects.requireNonNull(messagesId);
        this.messagesID = messagesId;
        return this;
    }
    
    @Override
     public MessagesStep appUserId(String appUserId) {
        Objects.requireNonNull(appUserId);
        this.appUserID = appUserId;
        return this;
    }
    
    @Override
     public AppUserStep messages(Messages messages) {
        Objects.requireNonNull(messages);
        this.messages = messages;
        return this;
    }
    
    @Override
     public BuildStep appUser(AppUser appUser) {
        Objects.requireNonNull(appUser);
        this.appUser = appUser;
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
    private CopyOfBuilder(String id, String messagesId, String appUserId, Messages messages, AppUser appUser) {
      super.id(id);
      super.messagesId(messagesId)
        .appUserId(appUserId)
        .messages(messages)
        .appUser(appUser);
    }
    
    @Override
     public CopyOfBuilder messagesId(String messagesId) {
      return (CopyOfBuilder) super.messagesId(messagesId);
    }
    
    @Override
     public CopyOfBuilder appUserId(String appUserId) {
      return (CopyOfBuilder) super.appUserId(appUserId);
    }
    
    @Override
     public CopyOfBuilder messages(Messages messages) {
      return (CopyOfBuilder) super.messages(messages);
    }
    
    @Override
     public CopyOfBuilder appUser(AppUser appUser) {
      return (CopyOfBuilder) super.appUser(appUser);
    }
  }
  
}
