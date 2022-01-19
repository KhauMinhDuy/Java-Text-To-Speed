import gtts
import sys


tts = gtts.gTTS(text=sys.argv[1], lang="vi")

tts.save("src/main/resources/hello.mp3")
