# 📅 강의 일정

## ✅ 1주차
- **3/4(화)** : 0. 오리엔테이션
- **3/6(목)** : 1. 기초 사항 / 2. 애플리케이션의 기본 구조

## ✅ 2주차
- **3/11(화)** : 3. 기본 위젯(1)
- **3/13(목)** : 3. 기본 위젯(1)

## ✅ 3주차
- **3/18(화)** : 3. 기본 위젯(1), **과제1: 에디트 텍스트 사용하기 2**
- **3/20(목)** : 4. 기본 위젯(2)

## ✅ 4주차
- **3/25(화)** :
**과제 1**
버튼을 누르면 두 개의 주사위가 각각 1부터 6까지의 숫자 중에서 랜덤하게 굴러가는 기능을 구현하세요.

**과제 2**
사칙연산이 가능한 계산기 앱을 구현하세요.  
예: `3 + 3 = 6`


- **3/27(목)** : 출장으로 인해 녹화강의

---

# Android 애플리케이션 기초

## 📌 클라썸 및 소스코드 링크
- **클라썸 주소**: [클라썸 링크](https://www.classum.com/main/space/218253/community)
- **이미란 교수님 소스코드**: [GitHub Repository](https://github.com/hci-du/2025-1-app)

---

# **1주차** 🔹 **기초 사항 / 애플리케이션의 기본 구조**

## **1. 안드로이드 애플리케이션의 주요 컴포넌트**
Android 애플리케이션은 **4가지 주요 컴포넌트**로 구성됨.


| **컴포넌트** | **설명** |
|------------|----------------------------|
| **액티비티 (Activity)** | 사용자 인터페이스(UI)를 담당하는 화면 단위의 컴포넌트 |
| **서비스 (Service)** | 백그라운드에서 실행되며 UI 없음 |
| **방송 수신자 (Broadcast Receiver)** | 시스템 또는 앱이 이벤트 발생 시 이를 감지하고 반응 |
| **컨텐트 제공자 (Content Provider)** | 다른 애플리케이션과 데이터 공유 및 관리 |

---

## **2. 안드로이드에서의 인텐트(Intent)**
**인텐트(Intent)**: 애플리케이션 간 또는 내부에서 컴포넌트를 실행하는 방법.

- **암시적(Implicit) 인텐트**: 특정 앱을 지정하지 않고, 안드로이드가 적절한 앱을 선택하여 실행
- **명시적(Explicit) 인텐트**: 특정 액티비티나 서비스를 지정하여 실행

📌 **인텐트 사용의 예**
<p align="left">
<img src="https://github.com/user-attachments/assets/426aeed8-dc63-48e7-839c-976b1773e3e7" width="550">
</p>

---

## **3. 안드로이드 애플리케이션의 구조**

Android 앱은 다음과 같은 **구성 요소**로 이루어집니다.

| **구성 요소** | **설명** |
|------------|---------------------------|
| **Java/Kotlin 파일** | 앱의 비즈니스 로직을 구현 |
| **XML 레이아웃 파일** | UI(사용자 인터페이스)를 정의 |
| **매니페스트(Manifest) 파일** | 앱의 정보 및 권한 설정 |
| **리소스 (drawable, values)** | 이미지, 색상, 문자열 등 포함 |
<p align="left">
<img src="https://github.com/user-attachments/assets/01c9c1f2-26dc-4ced-a764-fad0fd504f04" width="550">
</p>

---

## **4. 일반적인 애플리케이션 작성 절차**

1. **UI 디자인 (XML 파일)**
2. **Java 코드 작성**
3. **매니페스트 파일 작성**
4. **애플리케이션 실행 및 디버깅**
<p align="left">
<img src="https://github.com/user-attachments/assets/f5da3134-fa11-4baf-95b5-7802f1131fa9" width="550">
</p>

---

## 📌 중요 파일
- **`MainActivity.java`**: 메인 액티비티를 정의하는 코드  
- **`activity_main.xml`**: 메인 액티비티의 UI를 정의하는 XML 파일

---

# **2주차** 🔹 **기본 위젯(1)**

## 📏 UI 단위 개념 정리

| 개념 | 설명 |
|--------|--------|
| **Px (Pixel, Picture Elements)** | 화면의 픽셀 수 |
| **PPI (Pixels Per Inch)** | 1인치당 픽셀 수 |
| **DPI (Dots Per Inch)** | 1인치당 도트 수 (프린트에서 사용) |
| **DP (Density Independent Pixel)** | 밀도 독립형 픽셀 |
| **SP (Scale Independent Pixel)** | 확장 독립형 픽셀 |

📌 **1 인치 = 2.54cm**

---

<p align="left">
  <img src="https://github.com/user-attachments/assets/af1cbba3-a7f1-46eb-b135-3d36eb179dc1" width="550">
  <img src="https://github.com/user-attachments/assets/7fd43403-50de-4cb7-9e5e-4648fce0b126" width="400">
</p>

<p align="left">
  <img src="https://github.com/user-attachments/assets/1de5d784-5e93-4bc3-ab3e-3eb01b66646c" width="425">
  <img src="https://github.com/user-attachments/assets/c8e3e53b-0b18-43bf-a963-42506ee28c56" width="565">
</p>

<p align="left">
  <img src="https://github.com/user-attachments/assets/4233a361-e2f6-4e95-90ad-12ae8a363e85" width="800">
</p>

---

## 예제: 난수 표시 앱
<p align="left">
<img src="https://github.com/user-attachments/assets/4d761c5a-af2a-4bcf-b1ef-fd70465a93ac" width="300">
</p>

### **📌 MainActivity.java**
```java
package com.example.myapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView textViewRandomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewRandomNumber = findViewById(R.id.textViewRandomNumber);
    }

    public void generateRandomNumber(View view) {
        // 난수 생성
        Random random = new Random();
        int randomNumber = random.nextInt(100); // 0부터 99까지 난수 생성

        // 텍스트 뷰에 난수 표시
        textViewRandomNumber.setText("난수: " + randomNumber);
    }
}
```

### **📌 activity_main.xml**
```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">

    <TextView
        android:id="@+id/textViewRandomNumber"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="난수:"
        android:textSize="18sp" />

    <Button
        android:id="@+id/buttonGenerateRandom"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="랜덤 생성"
        android:onClick="generateRandomNumber"/>
</LinearLayout>
```

---

# **3주차** 🔹 **기본 위젯(1)(2), 과제1**

## 예제: 에디트 텍스트 사용하기 1

<p align="left">
<img src="https://github.com/user-attachments/assets/7e91269c-9393-439b-886e-35e951711b95" width="300">
</p>

### 📌 MainActivity.java

```java
package com.example.edittext_test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // 에디트텍스트 eText;
    // 버튼 eButton;
    // 텍스트뷰 eTextView;

    private EditText eText;
    private Button eButton;
    private TextView eTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 여기 부분 선언한 3개의 변수랑 XML ID
        eText = (EditText) findViewById(R.id.edittext);
        eButton = (Button) findViewById(R.id.button);
        eTextView = (TextView) findViewById(R.id.textView);
    }

    public void onClicked(View view) {
        String str = eText.getText().toString();
        eTextView.setText(str);
    }
}
```

### 📌 activity_main.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="409dp"
        android:layout_height="199dp"
        android:orientation="vertical"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="1dp">

        <EditText
            android:id="@+id/edittext"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="text"
            android:hint="여기에 텍스트를 입력하시오." />

        <Button
            android:id="@+id/button"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:onClick="onClicked"
            android:text="텍스트보이기" />

        <TextView
            android:id="@+id/textView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="텍스트보이기" />
    </LinearLayout>
</androidx.constraintlayout.widget.ConstraintLayout>
```

---

## 과제1: 에디트 텍스트 사용하기 2

<p align="left">
<img src="https://github.com/user-attachments/assets/0778ca85-da42-4b3b-8448-8122bf44ea93" width="300">
</p>

### 📌 MainActivity.java

```java
package com.example.edittext_ipp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // 아이디 etextID
    // 비밀번호 etextPW
    // 전화번호 etextPH
    // 버튼 eButton
    // 텍스트뷰 eTextView

    private EditText etextID;
    private EditText etextPW;
    private EditText etextPH;
    private Button eButton;
    private TextView eTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 여기 부분 선언한 5개의 변수랑 XML ID
        etextID = (EditText) findViewById(R.id.xml_editext);
        etextPW = (EditText) findViewById(R.id.xml_edittextPassword);
        etextPH = (EditText) findViewById(R.id.xml_edittextPhone);
        eButton = (Button) findViewById(R.id.xml_button);
        eTextView = (TextView) findViewById(R.id.xml_textView);
    }

    public void onClicked(View view) {
        String strID = etextID.getText().toString();
        String strPW = etextPW.getText().toString();
        String strPH = etextPH.getText().toString();

        eTextView.setText("아이디: " + strID + "\n" +
                "패스워드: " + strPW + "\n" +
                "전화 번호: " + strPH);
    }
}
```

### 📌 activity_main.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="409dp"
        android:layout_height="331dp"
        android:orientation="vertical"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="1dp">

        <EditText
            android:id="@+id/xml_editext"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="text"
            android:hint="아이디를 입력하세요." />

        <EditText
            android:id="@+id/xml_edittextPassword"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:hint="비밀번호를 입력하세요."
            android:inputType="textPassword" />

        <EditText
            android:id="@+id/xml_edittextPhone"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:hint="전화번호를 입력하세요."
            android:inputType="phone" />

        <Button
            android:id="@+id/xml_button"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:onClick="onClicked"
            android:text="회원가입" />

        <TextView
            android:id="@+id/xml_textView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="텍스트보이기" />
    </LinearLayout>
</androidx.constraintlayout.widget.ConstraintLayout>
```

---

## 예제: 이미지 속성 변경

<p align="left"">
<img src="https://github.com/user-attachments/assets/93c389b3-a284-4572-adae-41cea22d5236" width="300">
<img src="https://github.com/user-attachments/assets/50d5822b-0812-434d-baae-0b0a62241368" width="310">
</p>

### 📌 MainActivity.java

```java
package com.example.image_app;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private ImageView imageView; // XML_ID : imageView3
    private int scaleTyeIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageView = findViewById(R.id.imageView3);

    }

    public void changeScaleType(View view) {
        ImageView.ScaleType[] scaleTypes = {
                ImageView.ScaleType.CENTER,
                ImageView.ScaleType.CENTER_CROP,
                ImageView.ScaleType.CENTER_INSIDE,
                ImageView.ScaleType.FIT_CENTER,
                ImageView.ScaleType.FIT_XY
        };

        imageView.setScaleType(scaleTypes[scaleTyeIndex]);
        scaleTyeIndex = (scaleTyeIndex + 1) % scaleTypes.length;

    }

    public void changeRotation(View view) {
        imageView.setRotation(imageView.getRotation()+45);
    }

    public void changeAlpha(View view) {

        float alpha = imageView.getAlpha();


        // alpha = (alpha == 1.0f) ? 0.5f : 1.0f;

        if (alpha == 1.0f){
            alpha = 0.5f;
        }
        else alpha = 1.0f;


        imageView.setAlpha(alpha);

    }
}
```

### 📌 activity_main.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:id="@+id/linearLayout"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="1dp"
        android:layout_marginTop="1dp"
        android:layout_marginEnd="1dp"
        android:layout_marginBottom="1dp"
        android:orientation="vertical"
        app:layout_constraintBottom_toTopOf="@+id/linearLayout2"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <ImageView
            android:id="@+id/imageView3"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:srcCompat="@drawable/android" />
    </LinearLayout>

    <LinearLayout
        android:id="@+id/linearLayout2"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="1dp"
        android:layout_marginEnd="1dp"
        android:layout_marginBottom="229dp"
        android:orientation="horizontal"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/linearLayout">

        <Button
            android:id="@+id/button1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Scale Type변경"
            android:onClick = "changeScaleType"/>

        <Button
            android:id="@+id/button2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="회전 변경"
            android:onClick = "changeRotation"/>

        <Button
            android:id="@+id/button3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Alpha변경"
            android:onClick = "changeAlpha"/>
    </LinearLayout>
</androidx.constraintlayout.widget.ConstraintLayout>
```

---

# **4주차** 🔹 **수업예정**

수업예정

---
