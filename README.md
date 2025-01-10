## About
This is the main source tree for the Maven plugin. Any changes for the plugin will go *here*.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default. This will not be in the git source tree. Removed by ignore.

## Dependency Management

By Default Creamer does not have native support for plugin dependancies. Therefore, Maven uses a *custom* build process. See <a href="#building">Building</a> for more information.

# Contributing

Contributers are ***valued*** for there help in developing <a href="https://github.com/Leviathenn/creamer">**creamer**</a>, as well as fixing bugs in our plugins. Such as <u>this one</u>. But there needs to be a <u><i>strict</i></u> policy to ensure compatibility with creamer. Here are some policies that need to be enforced.

## Naming

Until more support is added for plugins, The Following Functions, and their publicity, argument names as well and types, can <u><b>*not*</b></u> be renamed <u>unless</u> supported by creamer change, as they will break the creamer plugin structure.

### Protected Functions: 

*   ```
    public String getDependancies(String information) 
    ```
*   ```
    public String getDependancies(String information) 
    ```
Note, also the class name of ```library``` can not be changed the current commit. 

# Building

To build the Maven plugin, clone this repo into your Creamer directory, than copy the Maven copy into the plugin-dev folder. Make sure the Maven Folder is in plugin-dev.

How you build this plugin is dependant on your version on Creamer.

## For the Development Kit ( Unbuilt )

In your *Creamer Root* run ```make plugins``` to build the plugin, from there you can refer back to instructions on how to build creamer, and install it.

** ⚠️⚠️⚠️USING MAKE HIGHLY UNRECOMENDED AND WILL BE DISCONTINUED IN THE NEAR FUTURE ⚠️⚠️⚠️ **

## For the User Kit / Development Kit ( Built )

If you have creamer in your path, you can run this command anywhere. Otherwise, in your creamer root. Run the following command. ```creamer --build-plugins```.



# Contributers

<a href="https://github.com/leviathenn/Maven/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=leviathenn/Maven" />
</a>

