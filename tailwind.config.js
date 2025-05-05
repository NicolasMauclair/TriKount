/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}"
  ],
  theme: {
    extend: {
      colors: {
        'ToastSuccess': '#28aa9e',
        'ToastSuccessBorder': '#1f7970',
        'ToastError': '#fe7845',
        'ToastErrorBorder': '#b15330'
      },
    },
  },
  plugins: [],
}

