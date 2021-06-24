CALL docker system prune
CALL docker compose build
REM # Se si desidera assegnare un nome specifico al container compose settare il parametro -p come da esempio
REM # CALL docker compose -p "isp-local-test0" up 
CALL docker compose up
