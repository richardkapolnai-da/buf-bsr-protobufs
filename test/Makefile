.PHONY: build
build:
	cd .. && buf build && buf generate
	mvn compile

.PHONY: clean
clean:
	mvn clean
	$(RM) -rf target/ build/
