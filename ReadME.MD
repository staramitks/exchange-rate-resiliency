# About
## Very Important from Resiliency Perspective
### Example for Resiliency4j
  - Retry
  - CircuitBreaker
  - RateLimiter
  - BulkHead
  - TimeLimiter

## Observabiility
 - Distributed Logging and Distributed Tracing
 - ElasticStack - collection of open Source tools for collection and analyzing of logs
 - Collect Logs - > LogStash (collect and transform) -> ElasticSearch -> Kibana (visualize and manage)
 - Open Telemetry - Zipkin - Track flow of request in distributed system
 - Liveness / Readiness and Health Checks
 - Prometheus and Grafana
 - Log Analytics Workspace - 
 - Data Visualization - KQL - Kusto Query Language - Charts / Graphs etc. 
 - Alerts and Notifications - PagerDuty 
 - Spring Bean Scope Testing
 - Swagger UI Testing - http://localhost:9080/swagger-ui/index.html
 - 

# Integrated with Prometheus
 - Application Prometheus Metrics URL - http://amitsingh:9080/actuator/prometheus
 - Start Prometheus - F:\Amit\Softwares\prometheus-2.46.0.windows-amd64>prometheus.exe --config.file=prometheus.yml
 - Prometheus URL - http://localhost:9090/graph
 - https://tanzu.vmware.com/developer/guides/spring-zipkin/