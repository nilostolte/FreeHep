# FreeHep
This project is a modification of FreeHep vector graphics **Java** package to exploit its capabilities of generating **SVG**, **EPS**, **GIF** and **EMF** from vector graphics drawn on a JPanel in Java. This project is ready for conmpilation in Eclipse. If you are already knowledgeable on transfering and compiling projects in Eclipse, just ignore the next section.

The heart of this project is the [**example**](https://github.com/nilostolte/FreeHep/tree/main/src/org/freehep/graphics2d/example) package, which is situated at [**org.freehep.graphics2d**](https://github.com/nilostolte/FreeHep/tree/main/src/org/freehep/graphics2d/example). Inside this [directory](https://github.com/nilostolte/FreeHep/tree/main/src/org/freehep/graphics2d/example), one can find [**ExportDialogExample2.java**](https://github.com/nilostolte/FreeHep/blob/main/src/org/freehep/graphics2d/example/ExportDialogExample2.java), which is a complete example showing how to convert the class [**MenuInfographics6.java**](https://github.com/nilostolte/Java-Vector-GUI/blob/main/MenuInfographics6/src/com/MenuInfographics6.java) in project [**MenuInfographics6**](https://github.com/nilostolte/Java-Vector-GUI/tree/main/MenuInfographics6#menuinfographics6) 
to be able to convert the graphics into **SVG**, **EPS**, **GIF** and **EMF** files. The conversion to **EMF** is only partial because EMF doesn't support gradient fills, which is unfortunately a very important feature in vector graphics. Normally when one needs to convert something to **EMF** it is just to be able to import the vector design to any **Microsoft Office** document. Actually, converting a vector design into **Office** is a quite hard task and the solution adopted was to generate **VBA code** to assemble the design inside **PowerPoint**. Once the design is defined inside PowerPoint it can be copied and pasted to other Office applications. This is a quite interesting niche for constructing an identical copy of the design inside **Office**, although the internal interfaces in VBA may change for different versions of Powerpoint. This has been coded in the project [MicroVBA](https://github.com/nilostolte/MicroVBA-PowerPoint).
There is another solution to this specific problem, which is using 
**LibreOffice**, but the conversion [can modify the original design](https://www.youtube.com/watch?v=U4GpOlExK98) and this requires the installition of the entire **LibreOffice** program. However, this later disadvantage can be bypassed by intalling a [**LibreOffice Portable**](https://www.libreoffice.org/download/portable-versions/) version into a **USB key** or into an **SD card**.

### Compiling Projects Using Eclipse

The advantage of these repositories is that no building software is necessary (no need for Maven), thus one doesn't even need to be a programmer to compile and to run the examples. One can easily compile the contents of these repositories using Eclipse for Java, for example. 

#### <ins>Creating Workspaces</ins>

When starting Eclipse it always asks for the path of the Workspace. A Workspace is just a directory where the projects are stored. It is highly recommended to put a complete path starting with the disk where one wants to store the projects. Although it is not very difficult to move a project from a place to another, it is easy to get lost if one has several workspaces in different disks or different paths. Putting several workspaces under the same directory is a good idea because it is easy to remember where they are, and it is also easier to make backups. It is recommended to maintain several workspaces instead of only one with all projects inside. If possible it is better to have one workspace per project, especially when it is a big project. One can have other small projects with the main project if they are fairly small and if they are tightly related to the main project.

#### <ins>Eclipse Welcome Tab</ins>

After supplying the Workspace directory, when Eclipse opens, a **Welcome** tab shows up inside Eclipse frame. This can be overwhelming to beginners, since instead of explaining you how to use it, and particularly how to dismiss this tab, it proposes a series of options. It is easier to ignore this page and dismiss it by clicking twice on the **"Welcome"** tab as indicated in **Fig. 1**.

![image](https://user-images.githubusercontent.com/80269251/114900322-c26c1e00-9de1-11eb-85df-ec175c466cd3.png)
**Figure 1** - Dismissing the **Welcome** tab
<br><br>

#### <ins>Creating a Project</ins>

The standard way to create a new project in Eclipse is by clicking **"File > New > Java Project"** (or alternatively pressing **Alt-Shift-N** simultaneously). Just ignore the suggestions shown at the Welcome tab and inside the Package Explorer, and proceed as shown in **Fig.**&#160;**2**.

![image](https://user-images.githubusercontent.com/80269251/114924821-61057880-9dfc-11eb-8826-1652bfdc5157.png)
**Figure 2** - Creating a new project by clicking **"File > New > Java Project"**
<br><br>

In the new opened window, one should type the name of the project and click on **Next** as shown in **Fig.**&#160;**3**.

![image](https://user-images.githubusercontent.com/80269251/114925801-8e065b00-9dfd-11eb-8f37-223e02ab6e41.png)
**Figure 3** - Naming the project and clicking **Next**
<br><br>

One should then uncheck the box **"Create module-info.java file"** and click **Finish**. This is shown in **Fig.**&#160;**4**. At some point it will be expected to be able to see the hierarchy of the project. This is allowed by clicking the "***>***" on the left of the project name in the Package Explorer, as indicated in the step **&#9314;** of **Fig.**&#160;**4**.

![image](https://user-images.githubusercontent.com/80269251/114929363-b09a7300-9e01-11eb-8662-a2cec64a09e1.png)
**Figure 4** - **&#9312;** Uncheck the box, **&#9313;** Click **Finish**, **&#9314;** Expand hierarchy by clicking on ***>***
<br><br>

Finally, one should be able to see the hierarchy of the packages that are added to the project. This is set as indicated in **Fig.**&#160;**5**. 

![image](https://user-images.githubusercontent.com/80269251/114927719-c9098e00-9dff-11eb-95ab-c4ee332aaef3.png)
**Figure 5** - Setting for showing package hierarchy by clicking "**&#x22EE; > Package Presentation > Hierarchical**"
<br><br>

#### <ins>Finding Files and Directories</ins>

If one is willing to access the directory where the project, a package or a file is located, there is a very simple and easy way to do it in Eclipse. Just click at the file, project or package one is trying to see in the file system and then right-click choosing **"Properties"** (at the bottom of the menu). A window will open and by clicking the icon on the right, as indicated in **Fig. 6**, a Window explorer (if one is working on Windows) window  will open at the directory where it is located.

<br>

![image](https://user-images.githubusercontent.com/80269251/114750182-b28d0500-9d21-11eb-8db8-21c33ef48ff2.png)<br>
**Figure 6** - Properties window of directory  [**`src`**](https://github.com/nilostolte/PDFBox/tree/main/PDFBox-Complete/src). On the right, where to click to open a file explorer window

<br>

In **Fig. 6**,  [**`src`**](https://github.com/nilostolte/PDFBox/tree/main/PDFBox-Complete/src) was clicked, the root of the source files in Eclipse. Once the file explorer opens one can dismiss the Properties window.

#### <ins>Compiling</ins>

After creating a new Java project in Eclipse (as shown in **Fig. 2**, **3**, **4** and **5**) and copying all the files in the source code under the directory [**`src`**](https://github.com/nilostolte/PDFBox/tree/main/PDFBox-Complete/src) to the directory **`src`** of your project, just click on the project name or **`src`**, and then on **"File > Refresh"**. Eclipse will then start to compile the code. Once the code is compiled you can already run the examples. Whenever a project is refreshed in Eclipse, whatever new `java` file found is compiled and the compiled file is saved in the **`bin`** directory in a same package storage hierarchy as the source code. Whenever a file is not a java file, it is just copied from **`src`** to **`bin`**. This is basically what happens when using Eclipse. Any new Java file created is automatically compiled on the fly. This simplicity and all the help when typing new code is what makes the beauty of Eclipse IDE. Classes, Interfaces, Enums and even new packages can be automatically created by just right clicking in the package you want to create them and choosing `New`.
