SRC_DIR = src
OUT_DIR = classes

WORKSHOP_JAR = workshopday09.jar
CSV_FILE= customers-2000000.csv

SOURCES = $(shell find $(SRC_DIR) -name '*.java')
JAVAC = javac
JFLAGS = -d $(OUT_DIR) -cp $(OUT_DIR)
JAVA = java

CLIENT_APP = workshopday09.App
MAP_COMPARISON_APP = workshopday09.MapComparison
MAP_THREADSAFE_APP = workshopday09.ThreadsafeMap

all: ${OUT_DIR} compile

${OUT_DIR}:
	mkdir -p ${OUT_DIR}

compile: ${SOURCES}
	${JAVAC} ${} ${JFLAGS} ${SOURCES}

run: compile
	${JAVA} -cp ${OUT_DIR} ${CLIENT_APP} ${CSV_FILE}  


jar: compile
	jar cvf ${WORKSHOP_JAR} -C ${OUT_DIR} .

run-jar: jar
	${JAVA} -cp ${WORKSHOP_JAR} ${CLIENT_APP} ${CSV_FILE}

run-map-jar: jar
	${JAVA} -cp ${WORKSHOP_JAR} ${MAP_COMPARISON_APP} 

run-mapthreadsafe-jar: jar
	${JAVA} -cp ${WORKSHOP_JAR} ${MAP_THREADSAFE_APP}

clean:
	@rm -rf ${OUT_DIR}
	@rm -rf ${WORKSHOP_JAR}
	
