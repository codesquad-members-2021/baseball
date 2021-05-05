import { useState, useEffect } from 'react'
const useFetch = (url, options) => {
    console.log(url)
  const [response, setResponse] = useState(null)
  const [error, setError] = useState(null)
  const [loading, setLoading] = useState(false)

  const fetchData = async () => {
    setLoading(true)    
    try {
      const res = await fetch(url)
      const json = await res.json()
      setResponse(json)
      setLoading(false)
    } catch (error) {
      setError(error)
      setLoading(false)
    }
  }
  useEffect(() => {
    fetchData()
  }, [])
  return { response, loading ,error }
}
export default useFetch
