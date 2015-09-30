# Android SQL Builder
Android SqlBuilder is a convenient tool to helping building a complex sql query statement
without developer worrying about the incorrect or missing SQL syntax. In addition, it also
takes care of automatic value binding.

## Installation
Include the following dependency in your build.gradle file of your project.

```xml
repositories {
    jcenter()
}

dependencies {
    compile 'com.guster:sqlbuilder:1.0.0'
}
...
```

## Example

```java
String query = SqlBuilder.newInstance()
                .select("u.*", "COUNT(p.*)")
                .from("users", "u")
                .innerJoin("u", "posts", "p", "p.user_id = u.user_id")
                .innerJoin("u", "books", "b", "b.user_id = u.user_id")
                .leftJoin("p", "comments", "c", "c.post_id = p.post_id")
                .where("u.user_id = :userId")
                .andWhere("u.status = :status")
                .groupBy("u.user_id")
                .orderBy("u.username")
                .bindValue("userId", "user123")
                .bindValue("status", 1)
                .build().getQuery();
```

# Developed by
* Guster Woei - <gusterwoei@gmail.com>

# License
```xml
 Copyright 2015 Gusterwoei

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
```


