# Maintenance assessment — 2026-11-01

## Recommendation

Retain as a lightweight Java 8 algorithm notebook if the examples are still useful. A small dependency update is proportionate; there is no framework to migrate. If no further practice or reference use is planned, archival after owner confirmation is also reasonable.

## Evidence and limits

- Reviewed default-branch commit `9a96806b2f7b2db820c2f66cd27376b92d9ba63a` (2021-08-30), recent history, complete source tree, README and POM. Work covers LeetCode, recursion, collections and concurrency; recent commits add practice examples rather than application deployment.
- The Java 8 build compiles 100 production source files. There is no Web framework, server entry point, deployment manifest or Actions workflow in the reviewed tree; no releases were returned. Multiple `main` methods are standalone exercises.
- No external deployment or downstream consumer was verified. Inactivity alone cannot prove that copied code is unused; the connector did not expose deployment enumeration for this inspection.

## Dependencies and real exposure

| Component | Baseline / scope | Assessment |
| --- | --- | --- |
| Guava | 25.0-jre / compile | Used only for `ThreadFactoryBuilder` in `leetcode/matrix/Solution2`. No Guava temporary-file methods or native deserialization input were found. Advisory version matches exist, but no vulnerable execution path was demonstrated. |
| JUnit | 4.11 / test | Only `AppTest.shouldAnswerWithTrue` uses it. No `TemporaryFolder` or sensitive temporary files. The reported local information-disclosure condition was not found; test dependencies are outside the runtime classpath. |
| Lombok | 1.18.10 / compile | Used by `@Data` and `@Slf4j`; retained to avoid unnecessary source rewrites. |
| SLF4J API | 1.7.29 / compile | Used by Lombok-generated logging; retained. No logging backend is configured. |

The [JUnit advisory](https://github.com/junit-team/junit4/security/advisories/GHSA-269g-pwp5-87pp) is fixed from 4.13.1 on Java 7+. The [Guava temporary-file advisories](https://github.com/advisories/GHSA-7g45-4rm6-3mm3) require a newer target than historical PR #2. The [2026 deserialization advisory](https://github.com/advisories/GHSA-xxph-c9ww-hj94) affects versions through 33.7.1 and is fixed in 33.7.2, so 32.x is insufficient as a current security baseline.

## Existing PRs

- [#1](https://github.com/Kidlovec/lc-repo/pull/1), still open: only updates JUnit 4.11 to 4.13.1. It addresses the identified JUnit advisory, but does not update Guava or reconcile Java target properties.
- [#2](https://github.com/Kidlovec/lc-repo/pull/2), still open: only updates Guava 25.0-jre to 29.0-jre. That target remains affected by later temporary-file and deserialization advisories.
- This draft combines Guava 33.7.2-jre, JUnit 4.13.2 and consistent Java 8 compiler properties. It supersedes those dependency changes if eventually merged. Neither historical PR was closed or merged.

## Options

| Option | Cost | Benefit / limitation |
| --- | --- | --- |
| Minimal update | Four POM value changes; no Java source or framework migration | Keeps exercises runnable, fixes currently matched Guava/JUnit advisories, aligns misleading Java 7 properties with the existing Java 8 plugin configuration. |
| Archive after confirmation | Low ongoing maintenance cost | Preserves a read-only notebook, but does not patch old artifacts or stop any external use. Best when future practice and maintenance have no value. |

## Validation

Actual runtime: Temurin 1.8.0_504; Maven 3.9.9. HTTPS Central was accessed using the environment proxy and trusted system CA store, without disabling TLS verification.

- Baseline `mvn -B clean verify`: **PASS**; 100 production sources compiled, one test passed, JAR produced.
- Updated `mvn -B clean verify`: **PASS** under Java 8; 100 production sources compiled, one test passed, JAR produced. No tests were skipped.
- The only automated test asserts `true`. This verifies build compatibility, not the correctness of 100 algorithm implementations or concurrency behavior. Standalone exercise `main` methods were not treated as tests or run as services.
- `maven-dependency-plugin:3.6.1:tree` completed before and after: 10 resolved JAR coordinates each, including test scope. Updated tree resolves Guava 33.7.2-jre and JUnit 4.13.2.
- OSV querybatch on 2026-11-01 for every resolved JAR coordinate: baseline matches Guava and JUnit; updated tree has zero matches across its 10 coordinates. Matches are version evidence, not proof of exploitable paths. Maven plugin dependencies were not scanned, and absence of matches is not a security guarantee.

No archival, merge or deployment is part of this draft.
