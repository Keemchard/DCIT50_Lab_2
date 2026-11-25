# DCIT 50 - Lab 2: Verification Forms (Java Swing)

This repository contains two Java Swing graphical applications for access and claim verification with attempt counters:
- `LabAccessVerificationForm.java`: Student ID and access code verification.
- `ClaimVerificationForm.java`: Reference number and claim code verification.

Both classes belong to the package `dcit50.gui`.

---

## Credentials for Testing

| Form | Field 1 | Field 2 | Max Attempts |
| :--- | :--- | :--- | :--- |
| **Lab Access Form** | **Student ID:** `2026-001` | **Access Code:** `LAB123` | 3 attempts |
| **Claim Verification Form** | **Reference No.:** `CLM-4821` | **Claim Code:** `PICKUP77` | 3 attempts |

> **Note:** Blank submissions do not deduct attempts. Incorrect submissions decrement remaining attempts until locked at `0`. The Reset/Clear button only clears input fields and does not restore attempts.

---

## 1. Running via Command Line (PowerShell / Command Prompt / Terminal)

### Compile
Always use lowercase `.java` (Java compilers are case-sensitive):
```powershell
javac -d bin *.java
```
The `-d bin` flag automatically generates the matching `dcit50/gui/` package directory inside `bin/`.

### Run

**Lab Access Verification Form:**
```powershell
java -cp bin dcit50.gui.LabAccessVerificationForm
```

**Claim Verification Form:**
```powershell
java -cp bin dcit50.gui.ClaimVerificationForm
```

**Single-Line Compile & Run:**
```powershell
javac -d bin *.java; java -cp bin dcit50.gui.LabAccessVerificationForm
```

---

## 2. Running in Visual Studio Code (VS Code)

### Prerequisites
1. Install a JDK (JDK 17 or JDK 21+ recommended).
2. Install the **Extension Pack for Java** by Microsoft from the VS Code Extensions Marketplace (`Ctrl + Shift + X`).

### Option A: Using the Integrated Terminal (Fastest)
1. Open this repository folder in VS Code (`File -> Open Folder...`).
2. Open the integrated terminal (`Ctrl + ` ` ` or `Terminal -> New Terminal`).
3. Compile and run:
   ```powershell
   javac -d bin *.java
   java -cp bin dcit50.gui.LabAccessVerificationForm
   ```

### Option B: Using VS Code's Run / Debug Button
Because the files declare `package dcit50.gui;`, Java Language Support expects the files to reside inside folders matching the package structure (`dcit50/gui/`) or within a configured source root.

#### Recommended Project Layout:
If you want the green **Run** / **Debug** button above `main` to work directly:
1. Create folder structure: `src/dcit50/gui/`
2. Move `ClaimVerificationForm.java` and `LabAccessVerificationForm.java` into `src/dcit50/gui/`.
3. Click **Run** or **Debug** directly above the `public static void main` method in the editor, or press `F5`.

#### Alternative via `.vscode/launch.json`:
If keeping the files in the root folder, create a `.vscode/launch.json` file:
```json
{
  "version": "0.2.0",
  "configurations": [
    {
      "type": "java",
      "name": "Run Lab Access Form",
      "request": "launch",
      "mainClass": "dcit50.gui.LabAccessVerificationForm"
    },
    {
      "type": "java",
      "name": "Run Claim Verification Form",
      "request": "launch",
      "mainClass": "dcit50.gui.ClaimVerificationForm"
    }
  ]
}
```

---

## 3. Running in Apache NetBeans

### Method 1: New NetBeans Ant Project (Recommended)
1. Launch **Apache NetBeans**.
2. Go to **File** -> **New Project...** (`Ctrl + Shift + N`).
3. Select **Java with Ant** in Categories, and **Java Application** in Projects. Click **Next**.
4. Set:
   - **Project Name:** `DCIT50_Lab_2`
   - **Create Main Class:** Uncheck this checkbox.
   - Click **Finish**.
5. In the **Projects** window on the left:
   - Expand `DCIT50_Lab_2` -> `Source Packages`.
   - Right-click `Source Packages` -> **New** -> **Java Package...**
   - Enter package name: `dcit50.gui` and click **Finish**.
6. Copy both `.java` files (`ClaimVerificationForm.java` and `LabAccessVerificationForm.java`) into the newly created `dcit50.gui` package (you can drag and drop them or copy-paste directly into NetBeans).
7. Right-click `LabAccessVerificationForm.java` (or `ClaimVerificationForm.java`) and select **Run File** (or press `Shift + F6`).

### Method 2: Set as Main Project & Run
1. After following Method 1, right-click the project `DCIT50_Lab_2` in the Projects tab -> **Properties**.
2. Select the **Run** category on the left.
3. Next to **Main Class**, click **Browse...** and choose `dcit50.gui.LabAccessVerificationForm` (or `ClaimVerificationForm`). Click **OK**.
4. Now, pressing the green **Play** button (`F6`) will automatically launch your selected form.

---

## Common Issues & Troubleshooting

- **`error: Class names, 'ClaimVerificationForm.Java', are only accepted if...`**
  - **Cause:** Using capital `.Java` instead of lowercase `.java`.
  - **Fix:** Always compile using lowercase: `javac -d bin *.java`.

- **`Error: Could not find or load main class dcit50.gui.LabAccessVerificationForm`**
  - **Cause:** The class files have not been compiled into `bin`, or the `-cp bin` classpath parameter was omitted.
  - **Fix:** Recompile with `javac -d bin *.java` and run with `java -cp bin dcit50.gui.LabAccessVerificationForm`.
