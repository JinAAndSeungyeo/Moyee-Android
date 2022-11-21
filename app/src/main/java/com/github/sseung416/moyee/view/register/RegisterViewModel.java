package com.github.sseung416.moyee.view.register;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.sseung416.moyee.view.SingleLiveEvent;

import java.util.List;

public class RegisterViewModel extends ViewModel {
     public MutableLiveData<String> id = new MutableLiveData<>("");
     public MutableLiveData<String> password = new MutableLiveData<>("");
     public MutableLiveData<String> passwordCheck = new MutableLiveData<>("");
     public MutableLiveData<String> name = new MutableLiveData<>("");
     public MutableLiveData<String> nickname = new MutableLiveData<>("");

     public SingleLiveEvent<Integer> next = new SingleLiveEvent<>(0);

     public MutableLiveData<String> errorMsg = new MutableLiveData<>("");

     public void verify(int position) {
         // todo(text resid화)
         switch (position) {
             case RegisterFragment.ID:
                 verifyIdAndPassword();
                 break;
             case RegisterFragment.NAME:
                 verifyNameAndNickname();
                 break;
             case RegisterFragment.KEYWORD:
                 nextPage();
                 break;
         }
     }

     private void verifyIdAndPassword() {
         String msg;
         String id = this.id.getValue().trim();
         String password = this.password.getValue().trim();
         String passwordCheck = this.passwordCheck.getValue().trim();

         if (id.isEmpty()) {
             msg = "아이디를 입력해주세요";
         } else if (password.isEmpty()) {
             msg = "비밀번호를 입력해주세요";
         } else if (!password.equals(passwordCheck)) {
             msg = "비밀번호와 비밀번호 확인이 맞지 않습니다.";
         } else {
             msg = "";
             nextPage();
         }

         errorMsg.setValue(msg);
     }

     private void verifyNameAndNickname() {
         String msg;
         String name = this.name.getValue().trim();
         String nickname = this.nickname.getValue().trim();

         if (name.isEmpty()) {
             msg = "이름을 입력해주세요.";
         } else if (nickname.isEmpty()) {
             msg = "닉네임을 입력해주세요.";
         } else {
             msg = "";
             nextPage();
         }

         errorMsg.setValue(msg);
     }

     private void nextPage() {
         next.setValue(next.getValue() + 1);
     }
}

class User {
    private String id;
    private String password;
    private String name;
    private String nickname;
    private List<String> keywordList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<String> getKeywordList() {
        return keywordList;
    }

    public void setKeywordList(List<String> keywordList) {
        this.keywordList = keywordList;
    }
}