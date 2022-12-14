docker stack ls >NUL  2>NUL
IF %ERRORLEVEL% NEQ 0 (
	docker swarm init
)
docker stack deploy -c docker-compose.yml SpringBootSample
