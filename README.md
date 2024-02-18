# Elite4J

Java Mapped Elite Dangerous Data Types (PlayerJournal/CAPI/IDs)

To use Elite4J in your Java project, you can include it as a dependency using Maven or Gradle.
Elite4J is currently deployed to the Maven Central Snapshot repository. Make sure you add
the snapshot repository.

<details>
<summary>**Maven:**</summary>

```xml
<repository>
  <id>maven-central-snapshots</id>
  <name>Mavevn Central Snapshots</name>
  <url>https://s01.oss.sonatype.org/content/repositories/snapshots/</url>
</repository>

<dependency>
    <groupId>space.tscg</groupId>
    <artifactId>elite4j</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

</details>

<details>
<summary>**Gradle:**</summary>

```groovy
repositories {
    maven {
        name = 'sonatype-snapshots'
        url = 'https://s01.oss.sonatype.org/content/repositories/snapshots/'
    }
}

dependencies {
    implementation 'space.tscg:elite4j:1.0.0-SNAPSHOT'
}
```

</details>

## Contributing

We welcome contributions from the community! If you have any ideas, bug fixes, or enhancements, feel free to open an issue or submit a pull request. Please make sure to follow the [contributing guidelines](CONTRIBUTING.md).

## License

Elite4J is licensed under the MIT License. See [LICENSE](LICENSE) for more information.
