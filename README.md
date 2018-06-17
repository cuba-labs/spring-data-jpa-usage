# Spring Data JPA Usage

This sample application demonstrates the usage of Spring Data JPA repositories.

Important points in the code:

* Adding dependency on Spring Data JPA: [build.gradle](https://github.com/cuba-labs/spring-data-jpa-usage/blob/master/build.gradle#L92)

* `javax.persistence.EntityManager` implementation delegating to CUBA `EntityManager`: [SpringDataEntityManager.java](https://github.com/cuba-labs/spring-data-jpa-usage/blob/master/modules/core/src/com/company/sample/core/SpringDataEntityManager.java)

* Bean that can instantiate Spring Data repositories: [Repositories.java](https://github.com/cuba-labs/spring-data-jpa-usage/blob/master/modules/core/src/com/company/sample/core/Repositories.java)

* Repository interfaces for the project entities: [com/company/sample/core/repositories](https://github.com/cuba-labs/spring-data-jpa-usage/tree/master/modules/core/src/com/company/sample/core/repositories)

* Usage of the repositories in [tests](https://github.com/cuba-labs/spring-data-jpa-usage/blob/master/modules/core/test/com/company/sample/core/SpringDataRepositoryTest.java) and in the [application code](https://github.com/cuba-labs/spring-data-jpa-usage/blob/master/modules/core/src/com/company/sample/service/OrderServiceBean.java)
