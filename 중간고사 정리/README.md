# 앱 프로그래밍 중간고사 대비 예상 문제 정리

## 1. (객관식) 안드로이드 OS의 주요 특징으로 옳지 않은 것은? 
**이론 개요:** 안드로이드 운영체제는 여러 **특징**을 가지고 있습니다 **(시험 출제 언급!: 안드로이드 OS의 특징)**. 주요 특징으로는 **① 리눅스 커널 기반**의 구조, **② 개방형 플랫폼(Open Source)**으로 다양한 제조사가 사용 가능, **③ 풍부한 앱 개발 환경**(전용 IDE인 Android Studio, 에뮬레이터 제공 등), **④ 다양한 멀티미디어와 하드웨어 지원** (예: 카메라, GPS, 센서, Bluetooth, Wi-Fi 등), **⑤ 애플리케이션 프레임워크 지원**으로 개발 용이성, **⑥ Java/Kotlin 언어 사용** 및 **⑦ SQLite 데이터베이스 내장** 등을 들 수 있습니다. 이러한 특징들은 **모바일 환경**에 최적화되어 있으며 **멀티태스킹과 앱 샌드박스 보안** 등의 장점도 포함됩니다.  

**오답 포인트:** 예를 들어, 보기 중 안드로이드의 특징이 아닌 것을 고르는 문제라면, *“안드로이드 애플리케이션은 C++로만 개발해야 한다”* 와 같은 문장은 틀린 설명입니다 (안드로이드는 **Java/Kotlin** 등으로 개발하며 네이티브 C/C++도 선택적으로 사용 가능). 이처럼 **안드로이드의 실제 특징과 반대되거나 부정확한 진술**을 구별해야 합니다. *또 다른 오답 예:* *“안드로이드에서는 멀티태스킹을 지원하지 않는다”* (안드로이드는 **멀티태스킹 지원**함). 문제에서 요구하는 내용은 **안드로이드의 올바른 특징**들을 숙지하고, **틀린 보기를 판별**하는 것입니다.  

## 2. (서술형) 안드로이드 애플리케이션의 구성 요소(Component)를 설명하시오.  
**이론 개요:** 안드로이드 앱은 네 가지 **핵심 구성요소**로 이루어집니다 **(강조!: 4대 컴포넌트)**. 각각의 구성 요소는 **AndroidManifest.xml에 등록**되어 앱을 구성합니다:  

- **액티비티(Activity):** 사용자 인터페이스를 담당하는 화면 단위 컴포넌트입니다. 일반적으로 **화면 하나당 하나의 액티비티**가 있으며, 사용자와의 **상호작용을 처리**합니다. 예를 들어, 메인 화면, 설정 화면 등이 각각 액티비티입니다. *액티비티는 앱에서 가장 중요하게 다루며, 수명주기(Lifecycle)를 가져 생성~종료까지 특정 메소드를 통해 상태 관리*합니다 **(강조!: Activity는 시험 중요 개념)**.  

- **서비스(Service):** 화면 없이 **백그라운드에서 동작하는 컴포넌트**입니다. 음악 재생, 알람, 네트워크 처리처럼 **오랫동안 또는 주기적으로 실행되는 작업**에 사용됩니다. 사용자가 보지는 못하지만 백그라운드에서 앱 기능을 수행합니다.  

- **방송 수신자(Broadcast Receiver):** 안드로이드 시스템이나 다른 앱에서 발생하는 **방송 메세지(Broadcast)**를 받아 처리하는 컴포넌트입니다. 예를 들어, 기기의 부팅 완료, 배터리 부족 알림 등의 시스템 브로드캐스트를 앱에서 받아 특정 동작을 수행할 수 있습니다.  

- **콘텐트 제공자(Content Provider):** 앱 간에 **데이터를 공유**할 수 있게 해주는 구성요소입니다. SQLite DB나 파일에 저장된 데이터를 다른 애플리케이션에서 접근하도록 할 때 사용합니다 (예: 주소록 앱의 데이터를 다른 앱이 조회).  

이 네 가지 중 **중간고사 범위에서는 주로 액티비티에 집중**하며, 서비스/방송 수신자/콘텐트 제공자는 개념 정도만 알아두면 됩니다 **(시험 출제 언급!: 특히 Activity에 대한 이해와 예시)**. 액티비티는 **생명주기 메소드**(`onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, `onDestroy`)를 통해 상태 변화 시 처리를 할 수 있고, 화면 회전 등으로 인한 재생성 등을 관리합니다.  

**교수님 강조 포인트:** *“애플리케이션은 액티비티가 모인 것이다”*라는 언급처럼, **하나의 앱은 여러 액티비티의 집합**으로 구성되며, 각 액티비티는 **Intent**를 통해 서로 전환됩니다 (Intent는 액티비티 간 데이터 전달/실행 명령 객체로 후반부에 학습 예정). 또한, 컴포넌트들은 필요에 따라 앱에서 선택적으로 사용되며 **모든 앱이 4가지를 모두 갖추는 것은 아닙니다** (예: 단순한 앱은 액티비티 하나만으로 구성되기도 합니다).  

## 3. (서술형) **Android Studio**란 무엇이며, 주요 기능과 역할은 무엇인가?  
**이론 개요:** **안드로이드 스튜디오(Android Studio)**는 안드로이드 앱 개발을 위한 **공식 통합 개발 환경(IDE)**입니다. **IntelliJ IDEA**를 기반으로 만들어졌으며, 구글이 지원하는 IDE로서 **안드로이드 앱 개발에 최적화된 다양한 도구**를 제공합니다 **(시험 출제 언급!: Android Studio 관련 내용)**. 주요 특징 및 역할은 다음과 같습니다:  

- **프로젝트 생성 및 관리:** Android Studio에서는 새로운 안드로이드 프로젝트를 쉽게 생성할 수 있고, Gradle 기반 **빌드 시스템**을 통해 의존성 관리와 APK 빌드를 자동화합니다.  

- **코드 편집기 및 디버거:** 자바(Java) 또는 코틀린(Kotlin) 코드를 편집하는 데 특화된 코드 에디터(자동 완성, 문법 검사 등)와 **디버깅 도구**를 제공합니다. 오류를 추적하고 앱을 단계별로 실행하며 변수 값을 확인할 수 있습니다.  

- **디자인 에디터(UI 편집기):** XML 레이아웃 파일을 시각적으로 편집할 수 있는 **레이아웃 편집기(Layout Editor)**를 제공합니다. 드래그앤드롭으로 버튼, 텍스트뷰 등의 **위젯**을 배치하고 속성을 변경하면 XML이 자동 생성되어 편리합니다. 실시간 미리보기로 다양한 화면 크기나 테마에서 UI가 어떻게 보이는지 확인할 수 있습니다.  

- **에뮬레이터와 디바이스 연결:** 앱을 테스트하기 위한 **안드로이드 가상 기기(AVD) 에뮬레이터**를 내장하고 있으며, 실제 휴대폰을 연결하여 **실행 및 디버그**할 수도 있습니다. 에뮬레이터는 다양한 폰 모델, 안드로이드 버전을 시뮬레이션하여 테스트 환경을 제공합니다.  

- **기타 개발 지원 기능:** 버전 관리(Git 연동), 메모리 및 CPU **프로파일러**(앱의 성능을 분석), UI **테마 편집기**, **APK 분석기** 등 앱 개발 전 주기를 지원하는 풍부한 도구를 갖추고 있습니다.  

**교수님 팁:** 시험에서는 *“안드로이드 스튜디오에 대한 설명으로 틀린 것은?”* 형태로 출제될 수 있습니다. 예를 들어, *“Android Studio는 Eclipse 기반의 IDE이다”* (틀림: IntelliJ 기반)와 같은 보기가 나올 수 있으므로, **Android Studio의 올바른 특징**(IntelliJ 기반, Gradle 사용, GUI 레이아웃 편집 지원 등)을 기억하고 있어야 합니다. 서술형으로 나온다면, **Android Studio의 정의와 주요 기능** (위에 언급한 내용들을 포함하여) 그리고 **왜 사용하는지** – 예를 들어 *“안드로이드 앱 개발에 필요한 종합적인 도구를 하나의 환경에서 제공하여 생산성을 높여준다”* – 와 같이 적으면 좋은 답안이 될 것입니다.  

## 4. (서술형) **PC 애플리케이션**과 **모바일(안드로이드) 애플리케이션**의 차이점을 3가지 이상 설명하시오.  
**이론 개요:** **데스크탑 PC용 애플리케이션**과 **모바일 안드로이드 애플리케이션**은 개발 환경과 실행 환경에서 여러 차이가 있습니다 **(시험 출제 언급!: PC vs 모바일 앱 차이)**. 주요한 차이점들을 정리하면 다음과 같습니다:  

- **운영 체제 & 실행 환경:** PC 애플리케이션은 주로 Windows, macOS 등의 OS에서 실행되고 **마우스/키보드**를 주입 장치로 사용합니다. 안드로이드 앱은 안드로이드 OS에서 동작하며 **터치스크린** 인터페이스와 제한된 하드웨어 자원(배터리, 메모리)을 고려한 설계가 필요합니다.  

- **앱 배포 방식:** PC 프로그램은 웹사이트나 스토어를 통해 설치파일(.exe, .dmg 등)을 다운로드/설치하거나 수동 배포합니다. **안드로이드 앱은 공식 마켓인 구글 Play 스토어** 등을 통해 배포되며, **APK**(또는 AAB) 패키지로 서명되어 배포됩니다. 또한 안드로이드에서는 **버전별 권한 관리와 샌드박스 보안**이 적용되어, 각 앱이 격리된 공간에서 동작합니다.  

- **화면 구성 & 반응형 디자인:** PC는 큰 모니터를 사용하고 창 단위 GUI를 가지는 반면, 모바일은 작은 화면에서 **액티비티(Activity)** 단위의 전체 화면 UI를 가집니다. 모바일 앱은 다양한 화면 크기와 해상도, 세로/가로모드 대응 등 **반응형 UI 디자인**이 필수입니다 (레이아웃을 dp 단위로 설계, 다양한 density 지원 등).  

- **자원 및 성능 제약:** 모바일 기기는 PC에 비해 CPU, 메모리, 저장공간 등이 제한적이고 배터리로 동작하므로, **전력 효율과 최적화**가 중요합니다. 예를 들어 PC 앱처럼 무거운 연산을 오래 하면 모바일에서는 발열이나 배터리 소모가 크므로, 안드로이드에서는 **백그라운드 서비스 제약**이나 **저전력 모드** 등을 고려해야 합니다.  

- **프로그래밍 플랫폼:** PC 애플리케이션은 다양한 언어/프레임워크(C#, C++ with Qt, Java Swing 등)로 개발되며, UI 툴킷도 각기 다릅니다. 안드로이드 앱은 **전용 SDK와 프레임워크** (안드로이드 SDK, UI 위젯, Activity 등)를 사용하고, Java/Kotlin으로 작성되며, **Android API 레벨** 호환성을 고려해야 합니다.  

이밖에도 **입출력 방식**(PC는 파일 시스템 접근 자유, Android는 권한을 통한 접근)과 **사용자 컨텍스트**(모바일은 언제 어디서나 사용, PC는 주로 업무/실내) 등의 차이가 있습니다.  
**정리:** 답안 작성 시 PC와 안드로이드 앱을 여러 측면(개발, 배포, UI, 자원 등)에서 비교하면 됩니다. 교수님도 **“특징이 아닌 **차이점**”**을 물어본다고 강조하셨으므로, 단순 나열보다 **양자의 차이를 대응 형태**로 쓰는 것이 포인트입니다. (예: "*PC는 ___한 반면, 모바일은 ___하다.*" 같은 구조로 서술).  

## 5. (서술형) **EditText와 TextView의 차이**를 설명하시오.  
**이론 개요:** **TextView**와 **EditText**는 둘 다 텍스트를 표시하는 안드로이드 **위젯(widget)**이지만 **용도와 특징에 차이**가 있습니다 **(시험 출제 언급!: EditText vs TextView 차이)**.  

- **TextView:** 화면에 **문자열을 표시하기 위한 용도**의 위젯입니다. 기본적으로 **읽기 전용** 텍스트를 보여주며, 사용자가 이를 편집할 수는 없습니다. 예를 들어 앱의 제목, 설명 글 등은 TextView로 표시합니다. TextView는 **사용자 입력을 받지 않고**, 주로 프로그램이 **setText()** 등을 통해 내용을 변경하거나 정적인 정보를 나타냅니다.  

- **EditText:** TextView를 상속받은 **입력 필드** 위젯으로, **사용자가 직접 텍스트를 입력하거나 수정할 수 있는** 텍스트 박스입니다. 흔히 **텍스트 입력창** (예: 로그인 화면의 아이디/비밀번호 입력란, 채팅 앱의 메시지 입력칸)에 사용됩니다. EditText는 포커스를 받아 **키보드가 올라오도록** 설계되어 있으며, 입력 내용에 따라 **실시간으로 TextChanged 이벤트**도 발생합니다. 또한 **hint** 속성을 통해 입력 가이드 문구를 회색으로 표시하거나, **inputType** 속성으로 숫자만 입력, 비밀번호 마스킹 등 **제한을 설정**할 수 있습니다.  

**주요 차이 요약:** EditText는 **커서가 깜빡이는 입력 가능한 필드**이고, TextView는 **단순 텍스트 표시**용이며 **커서나 키보드가 나타나지 않습니다**. EditText에는 `getText()` 메소드로 **사용자 입력 값을 가져올 수 있고** (`getText()`는 `Editable`을 반환하므로 **toString()을 사용**해 문자열로 변환 필요 – **강조!: getText().toString() 사용 이유**), TextView도 `getText()`로 텍스트를 얻을 순 있으나 사용자가 바꿀 일이 없습니다. 반대로 TextView에도 `setText()`로 프로그래matically 텍스트를 설정할 수 있지만 사용자 입력으로 변경되진 않습니다.  

아래는 **EditText와 TextView 사용 예시**입니다. XML 레이아웃에서 EditText에는 `hint` 및 `inputType`을 지정하고, TextView는 단순 출력 용도로 사용합니다:  

```xml
<!-- XML 예시: 회원가입 화면 일부 -->
<LinearLayout 
    android:orientation="vertical"
    ... >

    <!-- EditText: 사용자로부터 아이디를 입력받는 필드 -->
    <EditText
        android:id="@+id/editTextUserId"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="아이디를 입력하세요" 
        android:inputType="text" />  <!-- 일반 텍스트 입력 -->

    <!-- TextView: 안내 메시지를 표시하는 필드 -->
    <TextView
        android:id="@+id/textViewInfo"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="위 필드에 아이디를 입력해주세요." />

</LinearLayout>
```  

위 코드에서 EditText (`@+id/editTextUserId`)는 힌트로 “아이디를 입력하세요”가 보여지고 사용자가 터치하면 키보드로 텍스트를 입력할 수 있습니다. 반면 TextView(`@+id/textViewInfo`)는 단순 안내 문구를 표시하며 편집이 불가능합니다.  

**교수님 강조 포인트:** *“EditText와 TextView의 가장 큰 차이는 **사용자 입력 가능 여부**”*라는 언급대로, 시험 답변에서는 **“TextView는 출력 전용, EditText는 입력 가능”**을 명확히 써주면 됩니다. 추가로 EditText가 TextView의 서브클래스라는 것, 그리고 **UI/속성의 차이(hint, inputType 등 EditText만의 속성)**를 적어주면 좋은 답이 됩니다.  

## 6. (서술형) **`match_parent`**와 **`wrap_content`** 속성의 차이를 설명하고, 각각 언제 사용하는지 예를 드시오.  
**이론 개요:** 안드로이드의 레이아웃 XML에서 **View의 크기 지정 속성**으로 자주 쓰이는 것이 `layout_width`와 `layout_height`입니다. 이때 값을 고정 크기(예: `100dp`)로 줄 수도 있지만, 일반적으로 **`match_parent`와 `wrap_content`**라는 특수 값을 사용합니다 **(강조!: match_parent vs wrap_content)**. 두 속성의 동작 차이는 아래와 같습니다:  

- **`match_parent`** (과거 `fill_parent`): 부모 View(레이아웃)의 크기에 **맞춰서 View를 최대한 확장**시킵니다. 즉, **부모가 허용하는 남은 공간을 모두 차지**하도록 설정하는 값입니다. 가로폭을 `match_parent`로 하면 부모 레이아웃 폭 전체를 자기 폭으로 삼고, 세로를 `match_parent`로 하면 부모의 높이 (또는 부모 내 잔여 높이)를 모두 채웁니다. **예시:** 화면 폭 전체에 걸친 배너 이미지, 한 화면을 통째로 차지하는 ScrollView 등은 `layout_width`나 `layout_height`에 match_parent를 사용합니다.  

- **`wrap_content`**: 해당 View 내부의 콘텐츠(내용물)에 맞게 **크기가 딱 맞게** **wrap**됩니다. 즉, View 안에 포함된 텍스트나 자식 뷰들의 **필요한 크기만큼만 공간을 차지**하도록 설정합니다. `wrap_content`로 하면 내용이 클수록 View가 커지고, 내용이 작으면 View도 작아집니다. **예시:** 버튼의 가로폭을 `wrap_content`로 지정하면, 버튼 텍스트 길이에 따라 버튼 너비가 달라져서 텍스트를 감쌀 만큼만 넓어집니다.  

**사용 상황:**  
- `match_parent`는 **공간을 균등 또는 최대한 활용**해야 할 때 사용합니다. 예를 들어 상단바를 제외한 화면 전체를 차지하는 리스트뷰, 화면 너비 끝까지 펼쳐지는 이미지 등은 match_parent를 써야 가장 보기 좋습니다. 레이아웃 상에서 **남는 공간을 채우고자 할 때** 쓰는 개념으로 이해합니다.  
- `wrap_content`는 **콘텐츠 크기가 가변적**이거나, 내용에 따라 UI 크기가 자연스럽게 결정되도록 할 때 사용합니다. 예를 들어 여러 줄의 텍스트를 표시하는 TextView에 `wrap_content` 높이를 주면, 텍스트 양에 따라 높이가 자동 조절됩니다. 또한 아이콘과 글자가 함께 있는 버튼에서, 내용물 크기에 맞게 버튼이 작아지도록 하고 싶을 때 `wrap_content`를 사용합니다.  

다음은 예시 코드와 그 설명입니다:  

```xml
<!-- XML 예시: match_parent vs wrap_content -->
<LinearLayout 
    android:orientation="horizontal"
    android:layout_width="match_parent"   <!-- 부모인 화면 폭 전체 사용 -->
    android:layout_height="wrap_content"> <!-- 자식들의 높이에 맞춤 -->

    <Button
        android:text="확인"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_weight="1"/>  
        <!-- layout_weight를 1로 주고 width=0dp로 지정하면, 버튼이 남는 폭을 균등분할 -->
    
    <Button
        android:text="취소"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_weight="1"/>
        <!-- 두 버튼 모두 match_parent 대신 weight를 사용하여 50%씩 차지하도록 한 예 -->

</LinearLayout>
```  

위 LinearLayout은 가로 방향으로 배치되며, 두 버튼이 들어 있습니다. LinearLayout 자체의 폭은 `match_parent`라 화면 전체를 차지하고, 높이는 `wrap_content`라 내부 버튼들의 높이에 따라 결정됩니다. 버튼의 폭은 특별히 `layout_weight` 속성과 함께 사용된 예인데, `layout_width="0dp"`와 weight를 주어 두 버튼이 부모의 남은 공간을 1:1로 나눠 갖게 했습니다. 만약 weight를 쓰지 않고 각각 `wrap_content`로 했다면, 텍스트 `"확인"`, `"취소"`의 글자 폭만큼만 버튼이 만들어졌을 것입니다. 반대로 두 버튼 모두 `match_parent` 폭이라면 둘 다 가능한 최대 폭을 차지하려 하므로 한 버튼만 보이거나 비정상 배치되었을 것입니다.  

**추가 팁:** `match_parent`와 `wrap_content`는 **View 크기 지정의 기본 개념**으로, 면접이나 시험에 자주 나옵니다. `match_parent`는 *“부모 크기에 맞춘다”*, `wrap_content`는 *“내용물에 맞춘다”* 라고 기억하면 됩니다. 면접 답변처럼 간략히 쓰자면: **“match_parent는 부모영역을 채우는 것이고, wrap_content는 자신의 컨텐츠 크기만큼만 차지하는 것입니다.”** 라고 정리할 수 있습니다.  

## 7. (서술형) **px, dp, sp**는 무엇이며, 서로 어떤 차이가 있는지 설명하시오 (각 단위의 정의와 사용 사례 포함).  
안드로이드에서 UI 레이아웃을 디자인할 때, **화면 크기에 대응**하기 위해 절대 단위(px)보다 **상대 단위(dp, sp)**를 주로 사용합니다 **(시험 출제 언급!: 화면 단위 px/dp/sp 차이)**. 각 단위의 의미는 다음과 같습니다:

| 단위 | 정의 및 특징 | 사용 예시 및 용도 |
| --- | --- | --- |
| **px (pixel)** | *픽셀.* 화면상의 **물리적 픽셀 하나**를 의미하는 절대 단위입니다. 화면 해상도에 따라 **같은 px 값이어도 보이는 크기가 달라질 수 있습니다** (고해상도 폰에서는 매우 작게 보임). 일반적으로 UI 디자인에서 **권장되지 않는 단위**입니다. | 과거 고정 해상도 대상 앱에서는 사용했으나, 현대 안드로이드 앱에서는 거의 사용하지 않습니다. 특정 상황에서 정밀하게 1px 선을 그을 때 등 특별한 경우 외에는 dp/sp로 대체합니다. |

| **dp (dip)** <br/>(density-independent pixel) | *밀도 독립적 픽셀.* 디스플레이 **밀도(DPI)에 독립적인 가상 단위**로, **기본 밀도(160dpi)를 기준**으로 1dp가 1픽셀에 해당하도록 정의됩니다. 예를 들어 320dpi 화면에서는 1dp ≈ 2px로 자동 변환됩니다. 즉, **다른 화면 밀도에서도 물리적인 크기가 일정**하게 보이도록 스케일링해주는 단위입니다. | 레이아웃의 크기, 여백(margin/padding), 글꼴 크기 등 **대부분의 UI 요소 크기에 기본적으로 사용**합니다. 예를 들어 여백을 `16dp`로 주면, 저해상도 폰에서도 충분한 여백이 되고 고해상도 폰에서도 너무 좁지 않게 유지됩니다. |

| **sp** <br/>(scale-independent pixel) | *확장 독립 픽셀.* dp와 유사하게 밀도에 독립적이면서, 추가로 **사용자가 설정한 글꼴 크기(접근성 설정)**의 스케일을 반영하는 단위입니다. 주로 **텍스트 글꼴 크기 전용 단위**로 사용되며, **사용자 폰의 글꼴 크기 설정에 따라 sp로 지정한 크기가 가변**합니다. (예: 시스템 글꼴 크기를 크게 하면 sp단위 텍스트도 proportionally 크게 표시) | **텍스트 크기**는 기본적으로 sp 단위를 사용합니다. 예를 들어 `TextView`의 `textSize="18sp"`로 하면 보통 상황에서는 18dp 크기와 같지만, 사용자가 기기 설정에서 글꼴 크기를 “큰 글씨”로 해놓았다면 실제 렌더링되는 크기는 더 커집니다. **사용자 가독성 향상**을 위해 텍스트에는 sp 권장. <br/>단, **항상 동일한 크기로 보여야 하는 텍스트**(예: 앱 로고 이미지에 포함된 텍스트처럼)라면 dp를 쓰기도 합니다. |

**한줄 정리:** `px`는 화면 밀도에 따라 달라지는 **절대적 픽셀**, `dp`는 밀도에 비례 조정되는 **가상 픽셀**, `sp`는 여기에 **사용자 글꼴 설정까지 고려한 단위**입니다. 실무에서는 레이아웃은 **dp**로, 텍스트는 **sp**로 지정하는 것이 원칙입니다.  

**예시 설명:** 만약 5인치 160dpi 화면과 5인치 320dpi 화면이 있다면, `160dpi` 화면에서 `100px`로 지정한 뷰는 실제 5인치의 약 0.625인치 크기로 그려지지만, `320dpi` 화면에서 `100px`는 0.3125인치로 물리적 크기가 절반이 되어 매우 작게 보입니다. 그러나 `100dp`로 지정하면, 160dpi에서는 100px로, 320dpi에서는 200px로 자동 변환되어 **두 기기에서 물리적 크기가 약 0.625인치로 동일하게 유지**됩니다. 텍스트 크기도 100sp로 지정하면 위 변환과 함께 사용자 설정에 따른 비율이 적용됩니다.  

**교수님 팁:** px/dp/sp 개념은 시험의 단골 주제입니다. *“각각 정의를 쓰고 차이를 설명하라”* 또는 *"안드로이드에서 화면 해상도 대응을 위해 px 대신 사용하는 단위는?"* 같은 문제가 나올 수 있습니다. 답안에서는 **밀도 독립성**과 **사용자 가변성** 키워드를 포함하여, **dp와 sp를 쓰는 이유**(다양한 화면 지원 및 접근성)를 강조하세요.  

## 8. (서술형) XML 레이아웃의 **android:onClick** 속성을 통해 버튼 클릭 이벤트를 처리하려고 한다. 이때 연결될 **메소드의 조건**을 모두 쓰시오.  
**이론 개요:** XML에서 `<Button>` 등에 `android:onClick="메소드이름"` 속성을 지정하면, 해당 버튼이 클릭될 때 **액티비티의 메소드를 자동 호출**할 수 있습니다. 이를 사용하기 위해서는 액티비티에 **특정 형식의 메소드**를 정의해야 합니다. **그 메소드가 가져야 할 조건**은 다음과 같습니다 **(강조!: onClick 이벤트 메소드 조건)**:  

1. **`public` 접근 지정자이어야 한다:** XML에서 호출하기 때문에 앱 프레임워크가 외부에서 해당 함수를 찾습니다. 따라서 `private`이나 `protected`가 아닌 `public`으로 선언해야 합니다.  

2. **반환값이 `void`이어야 한다:** onClick 이벤트 처리 함수는 호출 후 아무 것도 반환하지 않습니다. 반환 타입을 작성하면 안 되며, 반드시 `void`이어야 합니다.  

3. **매개변수로 `View` 타입을 하나 받아야 한다:** 메소드 시그니처는 **`void methodName(View v)`** 형태여야 합니다. 여기서 View 매개변수는 클릭된 뷰(버튼)을 가리키며, 보통 구현에서는 사용하지 않아도 시그니처에 반드시 포함해야 합니다. (`View`는 `android.view.View`를 import해서 사용)  

4. **메소드 이름이 XML에 지정한 이름과 정확히 일치**해야 한다: 예를 들어 XML에 `android:onClick="onBtnClick"`이라고 써놓았다면 액티비티 자바 코드에 `public void onBtnClick(View v)` 형태로 메소드 이름과 철자까지 똑같이 맞춰야 호출됩니다. (오타가 있으면 실행시 **NoSuchMethodException 오류** 발생)  

5. **메소드가 정의된 액티비티 클래스가 해당 XML 레이아웃을 사용하는 액티비티와 동일해야 한다:** onClick으로 연결되는 메소드는 **현재 화면(Activity)의 멤버 메소드**로 존재해야 합니다. 다른 Activity에 같은 이름 메소드가 있더라도 호출되지 않으며, 반드시 현재 UI를 보여주는 액티비티 내부에 정의해야 합니다.  

**코드 예시:** 아래는 `activity_main.xml`에서 버튼에 onClick을 설정하고, `MainActivity.java`에 올바른 시그니처의 메소드를 작성한 경우입니다:  

```xml
<!-- XML 레이아웃: 버튼에 onClick 속성 지정 -->
<Button
    android:id="@+id/btnSubmit"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="제출"
    android:onClick="onSubmitButtonClick" />
```

```java
// Java 액티비티 코드: XML에서 지정한 이름과 일치하는 메소드 정의
public class MainActivity extends AppCompatActivity {
    // ... (필드 및 onCreate 생략)

    // 버튼 클릭 시 호출될 메소드 - 규칙에 맞게 선언
    public void onSubmitButtonClick(View v) {
        // 이벤트 처리 코드 (예: 입력값 가져와서 TextView에 보여주기)
        EditText inputField = findViewById(R.id.editTextUserInput);
        TextView resultView = findViewById(R.id.textViewResult);
        String text = inputField.getText().toString();  // EditText에서 문자열 가져오기 (Editable -> String 변환)
        resultView.setText("입력 내용: " + text);       // TextView에 결과 출력
    }
}
```  

위 코드에서 `android:onClick="onSubmitButtonClick"`으로 명시했고, 액티비티 내에 `public void onSubmitButtonClick(View v)` 메소드가 정의되어 있으므로 **버튼이 클릭될 때 해당 메소드가 자동 실행**됩니다. **(조건 만족:** public, void, View 파라미터, 이름 일치). 메소드 내부에서는 EditText의 입력을 `getText().toString()`으로 받아와 TextView에 `setText()`로 설정하는 예시 동작을 구현했습니다.  

**추가 설명:** XML의 onClick은 **간편하게 이벤트를 처리**할 수 있어 소규모 앱에서 자주 사용됩니다. 다만 익명 클래스나 람다로 `setOnClickListener`를 자바 코드에서 직접 등록하는 방식에 비해 **액티비티와 XML이 강하게 결합**된다는 특징이 있습니다. 시험 답안에서는 이러한 배경보다는 **메소드 선언 조건 3가지를 정확히 쓰는 것**이 핵심입니다 (public, void, View 매개변수).  

**교수님 언급:** *“버튼 이벤트를 처리하는 메소드의 조건”*을 강조하셨으며, 위의 조건을 모두 기억하고 있는지 확인할 수 있습니다. 또한, 부가적으로 EditText 관련 코드에서 **`getText().toString()`를 사용하는 이유**도 물어볼 수 있으므로 (Editable을 String으로 변환하기 위해) 유의하세요.  

## 9. (서술형) **ImageView의 이미지 속성 변경** – 예를 들어, 버튼을 눌러 **이미지를 45도 회전**시키거나 **투명도(Alpha)를 변경**하려면 어떻게 구현할 수 있는지 설명하시오.  
**이론 개요:** 안드로이드의 **ImageView** 위젯은 코드에서 다양한 메소드를 통해 이미지의 속성을 변경할 수 있습니다. 예제에서 다룬 **“Alpha 버튼”, “회전 버튼”** 기능 구현을 토대로, 버튼 클릭 시 ImageView의 **회전(angle)**과 **투명도(alpha)**를 조절하는 방법을 알아보겠습니다 **(시험 출제 언급!: ImageView 회전/투명도 제어)**.  

- **회전 (Rotation):** ImageView (또는 일반 View)의 `setRotation(float angle)` 메소드를 사용하면 해당 뷰를 **지정한 각도만큼 회전**시킬 수 있습니다. 각도 값은 **도(degree)** 단위이며, 기준축은 일반적으로 View의 중심(center pivot)입니다. 현재 회전 각도는 `getRotation()`으로 가져올 수 있습니다. 따라서 버튼을 누를 때마다 기존 각도에서 +45를 증가시키려면, `imageView.setRotation(imageView.getRotation() + 45)` 처럼 구현합니다. 이렇게 하면 누를 때마다 45도씩 추가 회전하게 됩니다.  

- **투명도 (Alpha):** View의 `setAlpha(float alpha)` 메소드를 사용하며, alpha 값은 **0.0f(완전 투명)**부터 **1.0f(완전 불투명)** 사이의 실수로 표현됩니다. ImageView의 현재 알파값은 `getAlpha()`로 얻을 수 있습니다. 예를 들어 버튼을 눌러 이미지가 반투명<->불투명 토글되게 하려면, 현재 알파를 가져와서 1.0이면 0.5로, 0.5이면 1.0으로 바꿔 `setAlpha()`를 호출합니다.  

**코드 예시:** 다음은 세 개의 버튼 (“크기/스케일 변경”, “회전 변경”, “Alpha 변경”)을 눌러 각 기능을 수행하는 코드 일부입니다. 특히 회전과 Alpha 관련 부분을 발췌합니다:  

```java
public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.myImageView);
    }

    // 회전 변경 버튼 onClick에 연결된 메소드 (XML에서 android:onClick="changeRotation")
    public void changeRotation(View view) {
        // 현재 회전 각도에 +45도 추가하여 설정
        float currentAngle = imageView.getRotation();
        imageView.setRotation(currentAngle + 45);
    }

    // 투명도 변경 버튼 onClick에 연결된 메소드 (XML에서 android:onClick="changeAlpha")
    public void changeAlpha(View view) {
        // 현재 알파값을 얻어와서 1.0 <-> 0.5 토글
        float alpha = imageView.getAlpha();
        if (alpha == 1.0f) {
            alpha = 0.5f;    // 불투명 -> 반투명
        } else {
            alpha = 1.0f;    // 반투명 -> 다시 불투명
        }
        imageView.setAlpha(alpha);
    }
}
```  

위 코드에서 `changeRotation` 메소드는 `imageView.getRotation()`으로 현재 각도를 가져와 +45도 시키고 `setRotation()`으로 적용합니다. `changeAlpha` 메소드는 `imageView.getAlpha()`로 현재 투명도를 받아 1.0이면 0.5로, 아니면 1.0으로 바꾼 후 `setAlpha()`로 적용합니다. **이 결과:** 사용자가 **회전 버튼**을 누를 때마다 이미지가 45도씩 회전하여 도는 효과, **Alpha 버튼**을 누를 때마다 이미지가 진해졌다 옅어졌다(100% 불투명 -> 50% 투명 -> 100% ...) 토글되는 효과가 나타납니다.  

- (참고) **스케일 타입 변경:** 예제 코드에는 이미지의 ScaleType을 순환 변경하는 기능(`setScaleType()`)도 있었는데, 이는 이미지의 **배치/크기 정책**을 바꾸는 것입니다 (예: CENTER, CENTER_CROP, FIT_XY 등). 이부분도 버튼으로 구현 가능하지만, 중간고사에서는 회전과 알파처럼 **View 속성을 변경**하는 대표 예시 두 가지를 알아두면 충분합니다.  

**정리:** ImageView 등 뷰의 속성은 이처럼 전용 메소드를 통해 조작합니다. 회전을 위한 `setRotation()`, 투명도를 위한 `setAlpha()` 사용법과 값 범위를 기억해두세요. **시험에서는** “이미지를 회전하기 위해 사용하는 메소드는 무엇인가?” 또는 “Alpha 값을 0으로 하면 어떤 효과가 나는가?” 같이 물을 수 있으니 (`setAlpha(0f)` -> 완전 투명으로 보여지지 않음) 주의를 기울입니다.  

## 10. (서술형) **LinearLayout과 RelativeLayout**의 차이점을 설명하고, 적절한 사용 사례를 비교하시오.  
**이론 개요:** 안드로이드 레이아웃에는 UI 요소들을 배치하기 위한 여러 **Layout** 클래스들이 있습니다. 그 중 **LinearLayout**과 **RelativeLayout**은 기본이 되는 두 가지 레이아웃 방식으로, **배치 방식과 속성에서 큰 차이**가 있습니다 **(강조!: Layout 종류 및 특성)**.  

- **LinearLayout:** 자식 뷰들을 **일렬로 나열**하는 레이아웃입니다. 방향을 `android:orientation` 속성으로 **수직(vertical)** 또는 **수평(horizontal)**으로 설정할 수 있으며, 설정된 방향으로 하나씩 **순차적으로 배치**합니다. **특징:** 단순한 배치에 용이하며, `layout_weight` 속성을 활용해 남은 공간을 비율대로 분할할 수 있습니다. 모든 자식이 직선으로 배열되기 때문에 **계층 구조가 단순**하고 예측 가능한 배치를 만듭니다. **사용 예:** 입력 폼처럼 위에서 아래로 여러 EditText와 버튼을 쌓아놓는 경우, 가로로 아이콘과 텍스트를 나란히 두는 경우 등.  

- **RelativeLayout:** 자식 뷰들을 **서로 상대적인 위치**로 배치하는 레이아웃입니다. 각 자식 뷰에 대해 **다른 뷰 혹은 부모에 대한 관계 속성**(예: `layout_toLeftOf="@id/다른뷰"`, `layout_alignParentTop="true"` 등)을 지정하여 위치를 결정합니다. **특징:** 자유도가 높아 **겹치거나 복잡한 배치**도 가능하며, LinearLayout에 비해 중첩 레이아웃을 줄일 수 있지만 **속성 구성이 다소 복잡**해질 수 있습니다. **사용 예:** 화면 내 특정 위치에 뷰를 겹치거나 배치해야 하는 경우 (예: 이미지 위에 텍스트를 겹쳐 표시, 버튼을 화면 맨 아래 정렬 등). RelativeLayout을 쓰면 하나의 레이아웃 안에서 다양한 배치를 구현할 수 있습니다.  

**비교 정리:**  
- LinearLayout은 **“줄 세우기”** 레이아웃입니다. 한 방향(가로/세로)으로만 배치하므로 **화면 흐름을 위아래 또는 좌우로 일관되게 구성**할 때 적합합니다. 구조가 단순한 대신에 복잡한 UI를 만들려면 LinearLayout 여러 개를 중첩해야 할 수 있습니다.  
- RelativeLayout은 **“상대 배치”** 레이아웃으로 **유연한 위치 지정**이 가능합니다. 예를 들어 *“B 뷰를 A 뷰의 오른쪽에 붙인다”*, *“C 뷰를 부모의 아래쪽에 정렬한다”* 등의 규칙을 적용해 한 레이아웃 안에서 다양한 배치를 할 수 있습니다. 다만 규칙을 잘못 설정하면 의도치 않은 겹침이나 배치가 될 수 있어 설계에 주의가 필요합니다.  

**사용 사례 예시:** 회원가입 화면을 만든다고 가정해보겠습니다. **간단한 회원가입 폼**(프로필 이미지, 여러 EditText, 버튼 1~2개)은 LinearLayout을 중첩하여 세로로 나열하고, 가로로 나열하는 방식으로 쉽게 구현할 수 있습니다. 반면 **프로필 화면**처럼 이미지 위에 텍스트를 겹치는 디자인이나, **자유로운 드래그 앤 드롭 UI** 같은 경우 RelativeLayout을 사용하면 한 Layout 내에서 구현할 수 있습니다.  

또 다른 예로, **계산기 앱 UI**를 생각해보면: 숫자 버튼들을 4x4 그리드로 배치하는 것은 LinearLayout을 중첩(행 LinearLayout 여러 개)하거나 TableLayout으로 할 수 있지만, RelativeLayout으로 각 버튼 위치를 일일이 지정하는 것은 비효율적입니다. 이처럼 **반복적이고 규칙적인 배치**는 LinearLayout이 유리하고, **비규칙적이고 개별 위치 조정이 필요한 배치**는 RelativeLayout이 편리합니다.  

**추가 정보:** 현대 개발에서는 RelativeLayout보다 더 유연하고 성능 좋은 **ConstraintLayout**을 주로 사용합니다. ConstraintLayout은 RelativeLayout의 업그레이드 버전으로, 각각의 뷰를 양쪽 또는 상하 **제약조건으로 연결**하여 복잡한 UI도 평면적으로(중첩 없이) 배치할 수 있습니다. 하지만 중간고사 범위에서는 LinearLayout, RelativeLayout까지만 다루었다면 각자의 개념과 차이를 언급하는 것으로 충분합니다.  

**정답 작성 팁:** Linear vs Relative는 **정의+비교+언제 어떤 걸 쓰는지**까지 쓰면 만점입니다. 교수님이 수업 시간에 각 레이아웃의 예제를 진행하셨다면 (회원가입 폼 예제 - LinearLayout 사용, 계산기 또는 겹치기 예제 - RelativeLayout 사용 등) 이를 언급하면서 차이를 설명하면 좋습니다. 키워드로 *“순차 배치 vs 상대 배치”, “orientation vs 위치속성”* 등을 넣으면 채점 포인트를 제대로 짚을 수 있습니다.  

## 11. (객관식) **android:background**와 **android:backgroundTint** 속성에 대한 설명으로 옳은 것은? (두 속성의 기능 차이)  
**이론 개요:** 안드로이드 뷰(View)의 배경을 지정할 때 `android:background`와 `android:backgroundTint` 두 속성을 볼 수 있습니다. 이들은 비슷해 보이지만 **동작 방식이 다르므로 결과가 달라질 수 있습니다** **(시험 출제 언급!: background vs backgroundTint 차이)**.  

- **android:background:** View의 배경으로 사용할 **drawable 리소스나 색상 값을 직접 지정**하는 속성입니다. 예를 들어 `android:background="@color/blue"`라고 하면 해당 View 배경이 바로 파란색으로 설정됩니다. **지정한 리소스 자체가 배경으로 적용**되며, 만약 동시에 backgroundTint가 적용되어 있어도 **background에 설정한 것으로 덮어써질 수 있습니다**. 쉽게 말해 **“배경을 이걸로 정해라”** 하는 직접 지시입니다.  

- **android:backgroundTint:** 기존에 적용된 배경(drawable)에 **색상을 겹씌워 입히는(tint) 속성**입니다. 마치 색상 필터를 배경에 적용하는 개념으로, Material 디자인을 따르는 위젯(예: MaterialButton 등)이나 AppCompat 테마를 사용하는 경우에 **의미 있게 동작**합니다. 예를 들어 기본 버튼은 테마에 따라 회색 배경(drawable)인데, `backgroundTint="@color/red"`로 주면 그 회색 기본 배경에 빨간색 틴트가 입혀져 결과적으로 빨갛게 보입니다. **중요:** backgroundTint가 효과를 내기 위해서는 기본 배경 리소스가 Tint를 수용하도록 설계되어야 합니다. 다행히 일반 Button이나 ImageView 등은 AppCompat을 통해 tint 적용이 가능합니다.  

**차이 강조:** `background`는 **완전히 새로운 배경으로 교체**하는 것이고, `backgroundTint`는 **현재 배경의 색조만 변경**하는 것입니다. 그래서 **동시에 사용될 때는 background가 우선 적용**되어 틴트가 의미 없어질 수 있고, 반대로 MaterialButton같이 기본 배경을 유지하며 색상만 바꾸고 싶을 때 backgroundTint를 쓰는 것이 편리합니다.  

**사용 예시:**  
- 어떤 뷰의 배경을 특정 이미지로 하거나, 모서리가 둥근 사각형 drawable로 하고 싶은 경우 `android:background="@drawable/my_shape"`처럼 **background를 직접 지정**합니다. 이때는 배경자체가 바뀌므로 tint와 상관없습니다.  
- 디자인 통일성을 위해 **기본 버튼 모양은 유지하면서 색상만 테마에 따라 변경**하고 싶다면 `android:backgroundTint`를 사용합니다. 예를 들어 `<Button>`에 `android:backgroundTint="@color/green"`을 주면 버튼 특유의 그림자는 유지한 채 녹색 계열 버튼이 됩니다.  

**객관식 정답 예시 풀이:** 만약 보기로  
① *“backgroundTint는 배경 색상을 덮어쓰는 속성이므로 background와 동일하게 동작한다”* – (잘못된 설명입니다. tint는 덮어쓰기 아니라 필터입니다)  
② *“background 속성에 색상을 지정하면 backgroundTint 설정은 무시될 수 있다”* – (맞는 설명입니다. background가 우선 적용되기 때문입니다)  
③ *“기본 Material 디자인 버튼의 색상을 바꾸려면 background보다 backgroundTint를 사용하는 것이 효과적이다”* – (옳은 설명입니다)  
④ *“backgroundTint는 모든 View 타입에서 아무 배경이나 동일하게 적용된다”* – (틀린 설명입니다. Tint는 기본 배경의 특성에 따라 다르게 적용될 수 있고, 지원되지 않는 경우도 있습니다)  

이런 선택지가 주어지면 옳은 답은 **②와 ③**이 될 것입니다. 시험에서는 하나만 고르는 문제일 수도 있고, 여러 개 고르는 형태일 수도 있으니 지문을 잘 읽어야 합니다. 핵심은: **background = 배경 교체, backgroundTint = 배경 색상 필터**라는 차이를 이해하는 것입니다.
