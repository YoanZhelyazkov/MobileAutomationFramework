# Mobile framework initial setup instructions on Windows OS

1.	Download and install **IntelliJ IDEA** (current version **2019**).

* Install **Gherkin** Plugin (File > Settings > Plugins).

2.	Install **Git** client.

3.	Install **Appium desktop** (Current stable version **1.15.0.1**).

4.	Install **Android Studio**.

5.	Open **IntelliJ IDEA** and use **checkout from Git** and clone the framework project from **Bitbucket**.

6.	Run Appium server with Host: **127.0.0.1** and port: **4723** .

7.	Run Android Studio.

* Install new Android emulator from AVD manager and start it.

8.	In **IntelliJ IDEA**, set the driver to **appium**, enter Appium **hub** address **http://127.0.0.1:4723/wd/hub** and the emulator **name**, **Android version** and **.APK** path in **serenity.conf** Android section.

9. Click right mouse button on the desired Mobile test and select Run.

**For additional capabilities or for overriding existing ones, please revise Serenity Maven Run Configurations: https://serenity-bdd.github.io/theserenitybook/latest/index.html**

---

# Mobile framework initial setup instructions on Mac OS (only to be used as remote server)

1. Install **Homebrew**:
* Homebrew is a package management software that will make it much simpler for us to install a few other software. To install, follow the instructions on this page: https://brew.sh/ . This step will also install the Xcode Command Line Tools as part of the process.

2. Install **Carthage**:
* Carthage is a dependency manager. In our case, it is required by WebDriverAgent. In terminal, enter the following:
```
brew install carthage
```
3. Install **Node & NPM**:
* Node is a javascript run-time environment and npm is the node package manager. We need these because Appium is a node application. In terminal, enter the following: (this command will install npm as well)
```
brew install node
```
4. Install **JDK** and set **JAVA_HOME**:
* Download the JDK, jdk-11.0.5_osx-x64_bin.dmg, from this link: https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html.

* Then double click the JDK and follow through all the installation steps.

5. Install **Xcode** and **Simulators**:
* Launch the Mac AppStore and download/install Xcode. Once installed, Launch Xcode and select Xcode > Preferences > Components to install the simulators that you might want to test against.

6. Install **authorize-ios**:
* authorize-ios is a little utility that pre-authorizes Instruments to run UIAutomation scripts against iOS devices. You need this utility to run tests on real devices

* In terminal, enter the following:
```
npm install -g authorize-ios
```
7. Install **ios-deploy**
* ios-deploy is a small utility to install and debug iPhone apps from the command line, without using Xcode.

* In terminal, enter the following:
```
brew install ios-deploy
```
8. Install **ideviceinstaller**
* ideviceinstaller is a tool to interact with the installation_proxy of an iOS device allowing to install, upgrade, uninstall, archive, restore and enumerate installed or archived apps. You also need this utility to run tests on real devices.
```
brew install ideviceinstaller
```
** If you are macOS High Sierra or Mojave you may encounter an error involving “invalid active developer path” in which case run the following command in terminal:
```
xcode-select --install
sudo xcode-select -r
```
* Then try install ideviceinstaller one more time.

9. Install **ios_webkit_debug_proxy**
* Appium uses this tool to access web views on real iOS devices. In terminal, run the following command
```
brew install ios-webkit-debug-proxy
```
10. Install **Appium**:
* Appium is an open source test automation framework for use with native, hybrid and mobile web apps. It drives iOS, Android and Windows mobile apps using the WebDriver protocol.

* In terminal, enter the following:
```
npm install -g appium@1.15.0.1
```
11. Install **Appium Doctor**
* Appium doctor is a mini software that checks all (well, almost all) of the preconditions for appium to run successfully. In terminal, enter the following:
```
npm install -g appium-doctor
```
12. Authorize **remote connections** in you Mac:
* In Spotlight search, type "Sharing" and confirm your search. In the Sharing panel, check Remote Login and, File Sharing options and Allow access for All users.

* Write down the IP address displayed, as you will use it in your **serenity.conf** file.  

13. Extract iOS .app from **applications/ios/Demo Application.zip**

14. In order to run tests on **Android** device, in **IntelliJ IDEA**, set the driver to **appium**, enter Appium **hub** IP address and the emulator **name**, **Android version** and **.APK** path in **serenity.conf** Android section.

15. In order to run tests on **iOS** device, start **iOS** emulator from **XCode** (Xcode > Open Developer tool > Simulator and set up a device) and set the **name**, **IP address**, **port**, **iOS version** and **.APP path** of the extracted app in the **serenity.conf** iOS section.

16. Run your desired tests from the **IntelliJ IDEA**.